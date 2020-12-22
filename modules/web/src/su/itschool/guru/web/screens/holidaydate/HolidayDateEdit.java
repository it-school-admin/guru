package su.itschool.guru.web.screens.holidaydate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.HolidayDate;

@UiController("guru_HolidayDate.edit")
@UiDescriptor("holiday-date-edit.xml")
@EditedEntityContainer("holidayDateDc")
@LoadDataBeforeShow
public class HolidayDateEdit extends StandardEditor<HolidayDate> {
}