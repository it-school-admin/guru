package su.itschool.guru.web.screens.classlevel;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassLevel;

@UiController("guru_ClassLevel.browse")
@UiDescriptor("class-level-browse.xml")
@LookupComponent("classLevelsTable")
@LoadDataBeforeShow
public class ClassLevelBrowse extends StandardLookup<ClassLevel> {
}