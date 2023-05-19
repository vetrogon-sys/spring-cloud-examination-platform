package org.example.history.controller;

import lombok.RequiredArgsConstructor;
import org.example.history.entity.Exercise;
import org.example.history.service.HistoryExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryExerciseService historyExerciseService;

    @GetMapping("/random")
    public List<Exercise> getExercises(@RequestParam(value = "amount",defaultValue = "1") Integer amount) {
        return historyExerciseService.getRandom(amount);
    }

}
