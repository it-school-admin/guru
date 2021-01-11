package su.itschool.guru.web.screens.classgrade;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassGrade;

@UiController("guru_ClassGrade.edit")
@UiDescriptor("class-grade-edit.xml")
@EditedEntityContainer("classGradeDc")
@LoadDataBeforeShow
public class ClassGradeEdit extends StandardEditor<ClassGrade> {
}