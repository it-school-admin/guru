package su.itschool.guru.web.screens.timetableimport;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableImport;

@UiController("guru_TimeTableImport.browse")
@UiDescriptor("time-table-import-browse.xml")
@LookupComponent("timeTableImportsTable")
@LoadDataBeforeShow
public class TimeTableImportBrowse extends StandardLookup<TimeTableImport> {
}