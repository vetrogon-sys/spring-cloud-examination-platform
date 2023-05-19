package org.example.math.service.impl;

import org.example.math.entity.Exercise;
import org.example.math.service.MathematicsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathematicsServiceImpl implements MathematicsService {

    private final Random random = new Random();
    @Value("${math.max:10}")
    private int max;


    @Override
    public Exercise getRandomExercise() {
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        return Exercise.builder().question(a + " + " + b + " = ?").answer(String.valueOf(a + b)).build();
    }

    @Override
    public int getMaxAvailableNumber() {
        return max;
    }

}
