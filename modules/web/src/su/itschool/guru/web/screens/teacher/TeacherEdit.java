package su.itschool.guru.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Teacher;

@UiController("guru_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
@LoadDataBeforeShow
public class TeacherEdit extends StandardEditor<Teacher> {
}