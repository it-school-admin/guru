package su.itschool.guru.service;

import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.entity.Teacher;

public interface EntitiesByIrTechIdFinderService {
    String NAME = "guru_EntitiesByIrTechIdFinderService";
    public Teacher findTeacherByIrTechId(Integer irTechId);

    Subject findSubjectByIrTechId(Integer irTechId);

    GroupForLesson findLearningSubGroup(Integer groupIrTechId, SchoolClass schoolClass, Integer subjectIrTechId);

    GroupForLesson findMainLearningGroup(Integer classIrTechId, Integer subjectIrTechId);
}