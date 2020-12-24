package su.itschool.guru.web.screens.academicholidays;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.AcademicHolidays;

@UiController("guru_AcademicHolidays.edit")
@UiDescriptor("academic-holidays-edit.xml")
@EditedEntityContainer("academicHolidaysDc")
@LoadDataBeforeShow
public class AcademicHolidaysEdit extends StandardEditor<AcademicHolidays> {
}