package su.itschool.guru.web.screens.holidaydate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.HolidayDate;

@UiController("guru_HolidayDate.browse")
@UiDescriptor("holiday-date-browse.xml")
@LookupComponent("holidayDatesTable")
@LoadDataBeforeShow
public class HolidayDateBrowse extends StandardLookup<HolidayDate> {
}