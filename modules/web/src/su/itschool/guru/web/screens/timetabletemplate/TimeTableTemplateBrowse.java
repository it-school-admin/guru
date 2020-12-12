package su.itschool.guru.web.screens.timetabletemplate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableTemplate;

@UiController("guru_TimeTableTemplate.browse")
@UiDescriptor("time-table-template-browse.xml")
@LookupComponent("timeTableTemplatesTable")
@LoadDataBeforeShow
public class TimeTableTemplateBrowse extends StandardLookup<TimeTableTemplate> {
}