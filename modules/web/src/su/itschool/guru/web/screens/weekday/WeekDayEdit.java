package su.itschool.guru.web.screens.weekday;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.WeekDay;

@UiController("guru_WeekDay.edit")
@UiDescriptor("week-day-edit.xml")
@EditedEntityContainer("weekDayDc")
@LoadDataBeforeShow
public class WeekDayEdit extends StandardEditor<WeekDay> {
}