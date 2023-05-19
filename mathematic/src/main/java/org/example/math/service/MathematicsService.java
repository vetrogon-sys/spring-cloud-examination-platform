package org.example.math.service;

import org.example.math.entity.Exercise;

public interface MathematicsService {

    Exercise getRandomExercise();

    int getMaxAvailableNumber();

}
