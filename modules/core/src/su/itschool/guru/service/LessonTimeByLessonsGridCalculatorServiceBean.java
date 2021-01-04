package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.*;
import su.itschool.guru.entity.enums.WeekDay;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service(LessonTimeByLessonsGridCalculatorService.NAME)
public class LessonTimeByLessonsGridCalculatorServiceBean implements LessonTimeByLessonsGridCalculatorService {

    @Inject
    private DataManager dataManager;

    @Override
    public LocalDateTime calculateStartTimeOfLesson(TimeTableTemplateItem templateItem, Week week) {
/*        LessonsGridItem lessonsGridItem = findLessonsGridItemByNumber(
                templateItem.getPlanningItem().getGroupOfLearning().getSchoolClass().getMainLessonsGridType(),
                templateItem.getNumberOfLesson());
        return getDateWithTime(templateItem.getWeekDay(), week, lessonsGridItem.getLessonStartTime());*/
        return null;
    }

    private LessonsGridItem findLessonsGridItemByNumber(LessonsGridType mainLessonsGridType, Integer numberOfLesson) {
        try {
            LessonsGridItem lessonsGridItem = dataManager.
                    load(LessonsGridItem.class).
                    query("select gi from guru_LessonsGridItem as gi " +
                            "WHERE " +
                            "gi.gridType = :lessonsGridType " +
                            "AND gi.lessonNumber = :lessonNumber").
                    parameter("lessonsGridType", mainLessonsGridType).
                    parameter("lessonNumber", numberOfLesson).
                    one();

            return lessonsGridItem;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    private LocalDateTime getDateWithTime(WeekDay dayOfWeek, Week week, LocalTime time) {
        return LocalDateTime.of(getDate(week, dayOfWeek), time);
    }

    private LocalDate getDate(Week week, WeekDay dayOfWeek) {
        return week.getStartDate().plusDays(dayOfWeek.getId()-1);
    }
}