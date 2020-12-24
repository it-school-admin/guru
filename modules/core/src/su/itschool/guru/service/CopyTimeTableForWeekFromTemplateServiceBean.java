package su.itschool.guru.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static su.itschool.guru.service.SettingsProviderService.DISTANT_LESSON_DEFAULT_DURATION;
import static su.itschool.guru.service.SettingsProviderService.FULL_TIME_LESSON_DEFAULT_DURATION;

@Service(CopyTimeTableForWeekFromTemplateService.NAME)
public class CopyTimeTableForWeekFromTemplateServiceBean implements CopyTimeTableForWeekFromTemplateService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Persistence persistence;
    @Inject
    private SettingsProviderService settingsProviderService;
    @Inject
    private LessonTimeByLessonsGridCalculatorService lessonTimeByLessonsGridCalculatorService;

    @Override
    public void copyTimeTableForWeekFromTemplate(Week week, Boolean isDistant) {
        List<TimeTableTemplateItem> templateItems = dataManager
                .load(TimeTableTemplateItem.class)
                .query("select ti from guru_TimeTableTemplateItem as ti")
                .viewProperties("groupForLesson",
                        "planningItem",
                        "dayOfWeek",
                        "timeStart",
                        "timeEnd",
                        "room",
                        "dayOfWeek.dayNumber")
                .list();

        for (TimeTableTemplateItem templateItem:templateItems)
        {
            Lesson lesson = dataManager.create(Lesson.class);
            lesson.setPlanningItem(templateItem.getPlanningItem());

            //TODO
            lesson.setStartTime(lessonTimeByLessonsGridCalculatorService.calculateStartTimeOfLesson(templateItem, week));
            if(isDistant)
            {
                lesson.setDuration(settingsProviderService.getIntegerParameter(DISTANT_LESSON_DEFAULT_DURATION));
            }
            else
            {
                lesson.setDuration(settingsProviderService.getIntegerParameter(FULL_TIME_LESSON_DEFAULT_DURATION));
            }
            lesson.setIsDistant(isDistant);
            lesson.setRoom(templateItem.getRoom());
            lesson.setWeek(week);
           dataManager.commit(lesson);
        }

    }


    @Override
    public void clearAllWeeks() {
        persistence.callInTransaction(tr->{
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_LESSON;").executeUpdate();
            return null;
        });

    }

    @Override
    public void clearWeek(Week selectedWeek) {
 /*       persistence.callInTransaction(tr->{
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_LESSON WHERE ;").executeUpdate();
            return null;
        });*/

    }
}