package su.itschool.guru.service;

import su.itschool.guru.entity.*;

public interface IrTechImportFinderService {
    String NAME = "guru_IrTechImportFinderService";
    Teacher findTeacherByIrTechId(Integer irTechId);

    Subject findSubjectByIrTechId(Integer irTechId);

    GroupForLesson findLearningSubGroup(Integer groupIrTechId, SchoolClass schoolClass, Integer subjectIrTechId);

    GroupForLesson findMainLearningGroup(Integer classIrTechId, Integer subjectIrTechId);

    LessonsGridItem getLessonGridItemByIrTechId(LessonsGridType lessonsGridType, Integer lessonTimeId);

    LessonsPlanningItem getPlanningItemByIrTechId(Integer irTechId);

    Room getRoomByIrTechId(Integer irTechId);

    GroupForLesson findRootGroupByClass(SchoolClass schoolClass);

    SchoolClass findClassByIrTechId(Integer irTechId);
}