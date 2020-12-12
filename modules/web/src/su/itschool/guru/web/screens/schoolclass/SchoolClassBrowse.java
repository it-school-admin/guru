package su.itschool.guru.web.screens.schoolclass;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.SchoolClass;

@UiController("guru_SchoolClass.browse")
@UiDescriptor("school-class-browse.xml")
@LookupComponent("schoolClassesTable")
@LoadDataBeforeShow
public class SchoolClassBrowse extends StandardLookup<SchoolClass> {
}