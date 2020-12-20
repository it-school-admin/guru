package su.itschool.guru.web.screens.weekday;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.WeekDay;
import su.itschool.guru.service.WeekDaysService;

import javax.inject.Inject;

@UiController("guru_WeekDay.browse")
@UiDescriptor("week-day-browse.xml")
@LookupComponent("weekDaysTable")
@LoadDataBeforeShow
public class WeekDayBrowse extends StandardLookup<WeekDay> {
    @Inject
    private WeekDaysService weekDaysService;

    @Subscribe("createWeekDaysButton")
    public void onCreateWeekDaysButtonClick(Button.ClickEvent event) {
        weekDaysService.createWeekDays("Понедельник", "Вторник", "Среда", "Четвер", "Пятница", "Суббота", "Воскресенье");
    }
}