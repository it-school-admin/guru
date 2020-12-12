package su.itschool.guru.web.screens.timetableimport;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableImport;

@UiController("guru_TimeTableImport.edit")
@UiDescriptor("time-table-import-edit.xml")
@EditedEntityContainer("timeTableImportDc")
@LoadDataBeforeShow
public class TimeTableImportEdit extends StandardEditor<TimeTableImport> {
}