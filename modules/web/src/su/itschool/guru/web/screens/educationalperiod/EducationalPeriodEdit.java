package su.itschool.guru.web.screens.educationalperiod;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalPeriod;

@UiController("guru_EducationalPeriods.edit")
@UiDescriptor("educational-period-edit.xml")
@EditedEntityContainer("educationalPeriodDc")
@LoadDataBeforeShow
public class EducationalPeriodEdit extends StandardEditor<EducationalPeriod> {
}