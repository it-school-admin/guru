package su.itschool.guru.web.screens.weekday;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.WeekDay;

@UiController("guru_WeekDay.browse")
@UiDescriptor("week-day-browse.xml")
@LookupComponent("weekDaysTable")
@LoadDataBeforeShow
public class WeekDayBrowse extends StandardLookup<WeekDay> {
}