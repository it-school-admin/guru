package su.itschool.guru.web.screens.groupforindividualplanning;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.GroupForIndividualPlanning;

@UiController("guru_GroupForIndividualPlanning.browse")
@UiDescriptor("group-for-individual-planning-browse.xml")
@LookupComponent("groupForIndividualPlanningsTable")
@LoadDataBeforeShow
public class GroupForIndividualPlanningBrowse extends StandardLookup<GroupForIndividualPlanning> {
}