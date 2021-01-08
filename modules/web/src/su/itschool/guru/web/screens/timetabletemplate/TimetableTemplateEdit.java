package su.itschool.guru.web.screens.timetabletemplate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimetableTemplate;

@UiController("guru_TimetableTemplate.edit")
@UiDescriptor("timetable-template-edit.xml")
@EditedEntityContainer("timetableTemplateDc")
@LoadDataBeforeShow
public class TimetableTemplateEdit extends StandardEditor<TimetableTemplate> {
}