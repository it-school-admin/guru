package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.WeekDay;

import javax.inject.Inject;

@Service(WeekDaysService.NAME)
public class WeekDaysServiceBean implements WeekDaysService {

    @Inject
    private DataManager dataManager;

    @Override
    public void createWeekDays(String... weekDayName) {
        // todo move to init application or to SQL script
        for(int i = 1; i < weekDayName.length+1; i++) {
            WeekDay weekDay = dataManager.create(WeekDay.class);
            weekDay.setDayNumber(i);
            weekDay.setDayName(weekDayName[i-1]);
            dataManager.commit(weekDay);
        }
    }
}