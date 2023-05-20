package com.example.examinator.controllers;

import com.example.examinator.model.CheckedExam;
import com.example.examinator.model.SolvedExam;
import com.example.examinator.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired(required = false)
    private ExamService examService;

    @PostMapping("/check")
    public CheckedExam checkExam(@RequestBody SolvedExam solvedExam) {
        return examService.convert(solvedExam);
    }
}
