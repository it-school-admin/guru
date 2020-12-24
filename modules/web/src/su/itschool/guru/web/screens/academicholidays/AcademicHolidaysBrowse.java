package su.itschool.guru.web.screens.academicholidays;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.AcademicHolidays;

@UiController("guru_AcademicHolidays.browse")
@UiDescriptor("academic-holidays-browse.xml")
@LookupComponent("academicHolidaysesTable")
@LoadDataBeforeShow
public class AcademicHolidaysBrowse extends StandardLookup<AcademicHolidays> {
}