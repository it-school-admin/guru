package su.itschool.guru.web.screens.timetabletemplate;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimetableTemplate;

@UiController("guru_TimetableTemplate.browse")
@UiDescriptor("timetable-template-browse.xml")
@LookupComponent("timetableTemplatesTable")
@LoadDataBeforeShow
public class TimetableTemplateBrowse extends StandardLookup<TimetableTemplate> {
}