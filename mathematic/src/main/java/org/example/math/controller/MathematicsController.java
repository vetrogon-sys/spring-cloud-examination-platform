package org.example.math.controller;

import lombok.RequiredArgsConstructor;
import org.example.math.entity.Exercise;
import org.example.math.service.MathematicsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class MathematicsController {
    private final MathematicsService mathService;

    @GetMapping("/random")
    public List<Exercise> getExercises(@RequestParam(value = "amount", defaultValue = "1") Integer amount) {
        return Stream.generate(mathService::getRandomExercise)
              .limit(amount)
              .collect(toList());
    }


}
