package su.itschool.guru.service;

import su.itschool.guru.entity.LessonsGridType;

public interface LessonsGridService {
    String NAME = "guru_LessonsGridService";
    void clearLessonsGrid(LessonsGridType lessonsGrid);
}