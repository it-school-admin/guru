package su.itschool.guru.web.screens.studyprofile;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyProfile;
import su.itschool.guru.service.StudyProfilesService;
import su.itschool.guru.web.bulkcreation.BulkCreationNotifier;

import javax.inject.Inject;

@UiController("guru_StudyProfile.browse")
@UiDescriptor("study-profile-browse.xml")
@LookupComponent("studyProfilesTable")
@LoadDataBeforeShow
public class StudyProfileBrowse extends StandardLookup<StudyProfile> {
    @Inject
    private Notifications notifications;
    @Inject
    private StudyProfilesService studyProfilesService;
    @Inject
    private CollectionLoader<StudyProfile> studyProfilesDl;

    @Subscribe("createStandardProfilesBtn")
    public void onCreateStandardProfilesBtnClick(Button.ClickEvent event) {
        new BulkCreationNotifier(notifications).showBulkCreationResult(studyProfilesService.createStandardProfiles());
        studyProfilesDl.load();
    }
}