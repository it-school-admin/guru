package su.itschool.guru.web.screens.classlevel;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassLevel;

@UiController("guru_ClassLevel.edit")
@UiDescriptor("class-level-edit.xml")
@EditedEntityContainer("classLevelDc")
@LoadDataBeforeShow
public class ClassLevelEdit extends StandardEditor<ClassLevel> {
}