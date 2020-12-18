package su.itschool.guru.web.screens.educationalyear;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalYear;

@UiController("guru_EducationalYear.browse")
@UiDescriptor("educational-year-browse.xml")
@LookupComponent("educationalYearsTable")
@LoadDataBeforeShow
public class EducationalYearBrowse extends StandardLookup<EducationalYear> {
}