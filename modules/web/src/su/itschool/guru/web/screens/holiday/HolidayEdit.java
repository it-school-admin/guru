package su.itschool.guru.web.screens.holiday;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Holiday;

@UiController("guru_Holiday.edit")
@UiDescriptor("holiday-edit.xml")
@EditedEntityContainer("holidayDc")
@LoadDataBeforeShow
public class HolidayEdit extends StandardEditor<Holiday> {
}