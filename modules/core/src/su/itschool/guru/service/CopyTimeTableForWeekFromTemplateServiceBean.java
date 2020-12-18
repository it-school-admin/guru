package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.entity.Week;
import su.itschool.guru.entity.WeekDay;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service(CopyTimeTableForWeekFromTemplateService.NAME)
public class CopyTimeTableForWeekFromTemplateServiceBean implements CopyTimeTableForWeekFromTemplateService {

    @Inject
    private DataManager dataManager;

    @Override
    public void copyTimeTableForWeekFromTemplate(Week week, Boolean isDistant) {
        List<TimeTableTemplateItem> templateItems = dataManager
                .load(TimeTableTemplateItem.class)
                .query("select ti from guru_TimeTableTemplateItem as ti")
                .viewProperties("groupForLesson", "planningItem", "dayOfWeek", "timeStart", "timeEnd", "room", "dayOfWeek.dayNumber")
                .list();

        for (TimeTableTemplateItem templateItem:templateItems)
        {
            Lesson lesson = dataManager.create(Lesson.class);
            lesson.setStudyGroup(templateItem.getGroupForLesson());
            lesson.setPlanningItem(templateItem.getPlanningItem());
            lesson.setStartTime(getDateWithTime(templateItem.getDayOfWeek(), week, templateItem.getTimeStart()));
            lesson.setEndTime(getDateWithTime(templateItem.getDayOfWeek(), week, templateItem.getTimeEnd()));
            lesson.setIsDistant(isDistant);
            lesson.setRoom(templateItem.getRoom());
            dataManager.commit(lesson);
        }

    }

    private LocalDateTime getDateWithTime(WeekDay dayOfWeek, Week week, LocalTime time) {
        return LocalDateTime.of(getDate(week, dayOfWeek), time);
    }

    private LocalDate getDate(Week week, WeekDay dayOfWeek) {
        return week.getStartDate().plusDays(dayOfWeek.getDayNumber()-1);
    }
}