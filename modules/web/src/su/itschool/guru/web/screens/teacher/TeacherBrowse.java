package su.itschool.guru.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Teacher;

@UiController("guru_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
@LoadDataBeforeShow
public class TeacherBrowse extends StandardLookup<Teacher> {
}