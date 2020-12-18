package su.itschool.guru.web.screens.week;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Week;

@UiController("guru_Week.edit")
@UiDescriptor("week-edit.xml")
@EditedEntityContainer("weekDc")
@LoadDataBeforeShow
public class WeekEdit extends StandardEditor<Week> {
}