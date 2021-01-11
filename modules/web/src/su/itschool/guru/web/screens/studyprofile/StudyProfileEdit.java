package su.itschool.guru.web.screens.studyprofile;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyProfile;

@UiController("guru_StudyProfile.edit")
@UiDescriptor("study-profile-edit.xml")
@EditedEntityContainer("studyProfileDc")
@LoadDataBeforeShow
public class StudyProfileEdit extends StandardEditor<StudyProfile> {
}