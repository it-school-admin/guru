package su.itschool.guru.web.screens.schoolclass;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.SchoolClass;

@UiController("guru_SchoolClass.edit")
@UiDescriptor("school-class-edit.xml")
@EditedEntityContainer("schoolClassDc")
@LoadDataBeforeShow
public class SchoolClassEdit extends StandardEditor<SchoolClass> {
}