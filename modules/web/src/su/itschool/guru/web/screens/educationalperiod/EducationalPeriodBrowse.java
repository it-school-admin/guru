package su.itschool.guru.web.screens.educationalperiod;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalPeriod;

@UiController("guru_EducationalPeriods.browse")
@UiDescriptor("educational-period-browse.xml")
@LookupComponent("educationalPeriodsTable")
@LoadDataBeforeShow
public class EducationalPeriodBrowse extends StandardLookup<EducationalPeriod> {
}