package su.itschool.guru.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Subject;

@UiController("guru_Subject.edit")
@UiDescriptor("subject-edit.xml")
@EditedEntityContainer("subjectDc")
@LoadDataBeforeShow
public class SubjectEdit extends StandardEditor<Subject> {
}