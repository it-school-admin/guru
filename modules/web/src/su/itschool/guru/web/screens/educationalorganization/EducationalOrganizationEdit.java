package su.itschool.guru.web.screens.educationalorganization;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalOrganization;

@UiController("guru_School.edit")
@UiDescriptor("educational-organization-edit.xml")
@EditedEntityContainer("educationalOrganizationDc")
@LoadDataBeforeShow
public class EducationalOrganizationEdit extends StandardEditor<EducationalOrganization> {
}