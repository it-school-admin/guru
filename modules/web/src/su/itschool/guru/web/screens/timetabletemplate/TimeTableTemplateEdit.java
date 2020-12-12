package su.itschool.guru.web.screens.timetabletemplate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableTemplate;

@UiController("guru_TimeTableTemplate.edit")
@UiDescriptor("time-table-template-edit.xml")
@EditedEntityContainer("timeTableTemplateDc")
@LoadDataBeforeShow
public class TimeTableTemplateEdit extends StandardEditor<TimeTableTemplate> {
}