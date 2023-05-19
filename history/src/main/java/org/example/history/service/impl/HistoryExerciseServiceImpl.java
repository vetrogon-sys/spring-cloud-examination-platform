package org.example.history.service.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.history.entity.Exercise;
import org.example.history.repository.ExerciseRepository;
import org.example.history.service.HistoryExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class HistoryExerciseServiceImpl implements HistoryExerciseService {
    @Setter
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Setter
    @Getter
    private int version;

    @Override
    public List<Exercise> getRandom(int amount) {
        List<Exercise> all = exerciseRepository.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }

    @Override
    @EventListener(ContextRefreshedEvent.class)
    public void fillDB() {
        log.info("Filling db with some data");
        List<Exercise> exercises = Arrays.asList(
              Exercise.builder().question("How old is Java?").answer("22").build(),
              Exercise.builder().question("How old is Groovy?").answer("16").build()
        );
        exerciseRepository.saveAll(exercises);
    }
}
