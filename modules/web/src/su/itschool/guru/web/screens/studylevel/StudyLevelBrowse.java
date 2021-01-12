package su.itschool.guru.web.screens.studylevel;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyLevel;
import su.itschool.guru.service.LevelService;
import su.itschool.guru.service.BulkCreationResult;

import javax.inject.Inject;
import java.util.Collection;

@UiController("guru_StudyLevel.browse")
@UiDescriptor("study-level-browse.xml")
@LookupComponent("studyLevelsTable")
@LoadDataBeforeShow
public class StudyLevelBrowse extends StandardLookup<StudyLevel> {
    @Inject
    private LevelService levelService;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<StudyLevel> studyLevelsDl;

    @Subscribe("addStandardLevelsBtn")
    public void onAddStandardLevelsBtnClick(Button.ClickEvent event) {
        BulkCreationResult result = levelService.fillStandardLevels();
        if(result.allIsOK())
        {
            notifications.create().withCaption("Записи созданы").show();
        }
        else {
            notifications.create()
                    .withCaption("Со следующими записями возникли проблемы:")
                    .withDescription(getMessageText(result.getNamesWithProblems()))
                    .show();

        }
        studyLevelsDl.load();
    }

    private String getMessageText(Collection<String> namesWithProblems) {
        StringBuilder result = new StringBuilder();
        for (String name: namesWithProblems)
        {
            result.append(name).append("\n");
        }
        return result.toString();
    }
}