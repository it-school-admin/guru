package su.itschool.guru.web.screens.schoolclassmapping;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.SchoolClassMapping;

@UiController("guru_SchoolClassMapping.browse")
@UiDescriptor("school-class-mapping-browse.xml")
@LookupComponent("schoolClassMappingsTable")
@LoadDataBeforeShow
public class SchoolClassMappingBrowse extends StandardLookup<SchoolClassMapping> {
}