package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.EducationalYear;
import su.itschool.guru.entity.Week;

import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.DayOfWeek.*;

@Service(FillingWeeksService.NAME)
public class FillingWeeksServiceBean implements FillingWeeksService {

    @Inject
    private DataManager dataManager;

    @Override
    public void fillWeeks(EducationalYear educationalYear) {
        Integer weeksCount = getWeeksCount(educationalYear);
        LocalDate weekStartDate = getFirstWeekStartDate(educationalYear);
        for (int weekNumber = 1; weekNumber < weeksCount+1; weekNumber++)
        {
            Week week = dataManager.create(Week.class);
            week.setWeekNumber(weekNumber);
            week.setStartDate(weekStartDate);
            week.setEndDate(weekStartDate.plusDays(6));
            week.setEducationalYear(educationalYear);
            dataManager.commit(week);
            weekStartDate = weekStartDate.plusWeeks(1);
        }
    }

    private LocalDate getFirstWeekStartDate(EducationalYear educationalYear) {
        LocalDate startDate = educationalYear.getStartDate();
        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        if (dayOfWeek == MONDAY)
        {
            return startDate;
        }
        if (dayOfWeek == TUESDAY)
        {
            return startDate.minusDays(1);
        }
        if (dayOfWeek == WEDNESDAY)
        {
            return startDate.minusDays(2);
        }
        if (dayOfWeek == THURSDAY)
        {
            return startDate.minusDays(3);
        }
        if (dayOfWeek == FRIDAY)
        {
            return startDate.minusDays(4);
        }
        if (dayOfWeek == SUNDAY)
        {
            return startDate.minusDays(5);
        }
        return startDate.minusDays(6);
    }

    private Integer getWeeksCount(EducationalYear educationalYear) {
        long days = ChronoUnit.DAYS.between(educationalYear.getStartDate(), educationalYear.getEndDate());
        return (int)Math.ceil(days/7);
    }
}