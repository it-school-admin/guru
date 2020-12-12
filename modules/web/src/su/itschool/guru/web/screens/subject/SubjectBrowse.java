package su.itschool.guru.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Subject;

@UiController("guru_Subject.browse")
@UiDescriptor("subject-browse.xml")
@LookupComponent("subjectsTable")
@LoadDataBeforeShow
public class SubjectBrowse extends StandardLookup<Subject> {
}