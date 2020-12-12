package su.itschool.guru.web.screens.educationalorganization;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalOrganization;

@UiController("guru_School.browse")
@UiDescriptor("educational-organization-browse.xml")
@LookupComponent("educationalOrganizationsTable")
@LoadDataBeforeShow
public class EducationalOrganizationBrowse extends StandardLookup<EducationalOrganization> {
}