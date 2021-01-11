package su.itschool.guru.web.screens.classgrade;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassGrade;

@UiController("guru_ClassGrade.browse")
@UiDescriptor("class-grade-browse.xml")
@LookupComponent("classGradesTable")
@LoadDataBeforeShow
public class ClassGradeBrowse extends StandardLookup<ClassGrade> {
}