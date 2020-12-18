package su.itschool.guru.web.screens.educationalyear;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalYear;

@UiController("guru_EducationalYear.edit")
@UiDescriptor("educational-year-edit.xml")
@EditedEntityContainer("educationalYearDc")
@LoadDataBeforeShow
public class EducationalYearEdit extends StandardEditor<EducationalYear> {
}