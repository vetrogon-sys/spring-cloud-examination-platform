package com.example.examinator.services;

import com.example.examinator.dao.ExerciseDao;
import com.example.examinator.model.CheckedExam;
import com.example.examinator.model.Exercise;
import com.example.examinator.model.SolvedExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExerciseDao dao;

    @Autowired
    private SectionDao dao2;
    @Override
    public CheckedExam convert(SolvedExam solvedExam) {
        return CheckedExam.builder().exam(solvedExam.getExam()).mark(80).build();
    }

    @Override
    public List<Exercise> getExercises() {
        return dao.getDefault();
    }
}
