package su.itschool.guru.web.screens.holiday;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Holiday;

@UiController("guru_Holiday.browse")
@UiDescriptor("holiday-browse.xml")
@LookupComponent("holidaysTable")
@LoadDataBeforeShow
public class HolidayBrowse extends StandardLookup<Holiday> {
}