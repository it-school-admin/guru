package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.StudyProfile;

import javax.inject.Inject;
import java.util.Collection;

import static java.util.Arrays.asList;

@Service(StudyProfilesService.NAME)
public class StudyProfilesServiceBean implements StudyProfilesService {
    private static Collection<String> profileNames = asList("гуманитарный", "технологический", "естественно-научный", "социально-экономический", "универсальный");
    @Inject
    private DataManager dataManager;

    @Override
    public BulkCreationResult createStandardProfiles() {
        BulkCreationResult bulkCreationResult = new BulkCreationResult();
        for (String profileName: profileNames)
        {
            StudyProfile studyProfile = dataManager.create(StudyProfile.class);
            studyProfile.setProfileName(profileName);
            try {
                dataManager.commit(studyProfile);
            }
            catch (Exception e)
            {
                bulkCreationResult.addErrorResult(profileName);
            }
        }

        return bulkCreationResult;
    }
}