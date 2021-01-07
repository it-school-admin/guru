package su.itschool.guru.service;

import su.itschool.guru.entity.*;

public interface IrTechImportFinderService {
    String NAME = "guru_IrTechImportFinderService";
    Teacher findTeacherByIrTechId(Integer irTechId);

    Subject findSubjectByIrTechId(Integer irTechId);

    GroupForLesson findSubGroupByIrTechIdAndClass(Integer irTechId, Integer schoolClassIrTechId);

    GroupForLesson findRootClassGroup(Integer classIrTechId);

    LessonsGridItem getLessonGridItemByIrTechId(LessonsGridType lessonsGridType, Integer lessonTimeId);

    LessonsPlanningItem getPlanningItemByIrTechId(Integer irTechId);

    Room getRoomByIrTechId(Integer irTechId);

    SchoolClass findClassByIrTechId(Integer irTechId);

    GroupForIndividualPlanning findIndividualPlanSubgroupByPlanItemIrTechId(Integer planItemIrTechId);
}