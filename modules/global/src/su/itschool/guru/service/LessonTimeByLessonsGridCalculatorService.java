package su.itschool.guru.service;

import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.entity.Week;

import java.time.LocalDateTime;

public interface LessonTimeByLessonsGridCalculatorService {
    String NAME = "guru_LessonTimeByLessonsGridCalculatorService";

    LocalDateTime calculateStartTimeOfLesson(TimeTableTemplateItem templateItem, Week week);
}