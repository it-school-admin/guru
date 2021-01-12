package su.itschool.guru.service;

import su.itschool.guru.entity.StudyLevel;
import su.itschool.guru.entity.enums.PlanningType;

public interface GradesService {
    String NAME = "guru_GradesService";

    BulkCreationResult createGrades(Integer from, Integer to, StudyLevel level, PlanningType planningType);
}