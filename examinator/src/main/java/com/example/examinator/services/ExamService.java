package com.example.examinator.services;

import com.example.examinator.model.CheckedExam;
import com.example.examinator.model.Exercise;
import com.example.examinator.model.SolvedExam;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ExamService {

    CheckedExam convert(SolvedExam solvedExam);

    List<Exercise> getExercises();
}
