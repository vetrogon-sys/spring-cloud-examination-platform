package com.example.examinator.controllers;

import com.example.examinator.model.Exam;
import com.example.examinator.model.Exercise;
import com.example.examinator.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/exams")
public class ExamComposerController {
    private final RestTemplate restTemplate;

    private int number = 1;

    @Autowired
    public ExamComposerController(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/exam")
    public Exam createExam(@RequestBody Map<String, Integer> examSpec) {
        List<Section> sections = examSpec.entrySet()
              .stream()
              .map(this::getSectionForEntry)
              .collect(toList());
        return Exam.builder().sections(sections).title("Best exam #" + number++).build();
    }

    private Section getSectionForEntry(Map.Entry<String, Integer> entry) {
        List<Exercise> exercises = getExercisesForEntry(entry);
        return Section.builder()
              .exercises(exercises)
              .title(entry.getKey())
              .build();
    }

    private List<Exercise> getExercisesForEntry(Map.Entry<String, Integer> entry) {
        String title = entry.getKey();
        String url = getServiceUrl(title, entry.getValue());
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, Exercise[].class)));
    }

    public String getServiceUrl(final String service, final int amount) {
        return "http://" + service + "/exercises/random?amount=" + amount;
    }
}
