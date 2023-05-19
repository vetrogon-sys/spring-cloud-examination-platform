package com.example.examinator.dao;

import com.example.examinator.model.Exercise;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ExerciseDao {
    List<Exercise> getDefault();

}
