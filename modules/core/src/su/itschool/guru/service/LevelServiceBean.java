package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.StudyLevel;

import javax.inject.Inject;
import java.util.Collection;

import static java.util.Arrays.asList;

@Service(LevelService.NAME)
public class LevelServiceBean implements LevelService {

    Collection<String> russianStudyLevels = asList("Начальное образование", "Общее образование", "Среднее образование");

    @Inject
    private DataManager dataManager;

    @Override
    public BulkCreationResult fillStandardLevels() {
        BulkCreationResult result = new BulkCreationResult();
        for (String levelName: russianStudyLevels)
        {
            result.addResult(levelName, createLevel(levelName));
        }
        return result;
    }

    private Boolean createLevel(String levelName) {
        StudyLevel studyLevel = dataManager.create(StudyLevel.class);
        studyLevel.setLevelName(levelName);

        try {
            dataManager.commit(studyLevel);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
}