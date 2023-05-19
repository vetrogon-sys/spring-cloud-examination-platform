package org.example.history.service;

import org.example.history.entity.Exercise;

import java.util.List;

public interface HistoryExerciseService {

    List<Exercise> getRandom(int amount);

    void setVersion(int version);

    int getVersion();

    void fillDB();

}
