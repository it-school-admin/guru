package su.itschool.guru.web.screens.studyprofile;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyProfile;

@UiController("guru_StudyProfile.browse")
@UiDescriptor("study-profile-browse.xml")
@LookupComponent("studyProfilesTable")
@LoadDataBeforeShow
public class StudyProfileBrowse extends StandardLookup<StudyProfile> {
}