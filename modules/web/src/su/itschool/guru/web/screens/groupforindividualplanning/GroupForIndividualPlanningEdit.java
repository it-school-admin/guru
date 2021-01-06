package su.itschool.guru.web.screens.groupforindividualplanning;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.GroupForIndividualPlanning;

@UiController("guru_GroupForIndividualPlanning.edit")
@UiDescriptor("group-for-individual-planning-edit.xml")
@EditedEntityContainer("groupForIndividualPlanningDc")
@LoadDataBeforeShow
public class GroupForIndividualPlanningEdit extends StandardEditor<GroupForIndividualPlanning> {
}