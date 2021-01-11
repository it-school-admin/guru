package su.itschool.guru.web.screens.studylevel;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyLevel;

@UiController("guru_StudyLevel.browse")
@UiDescriptor("study-level-browse.xml")
@LookupComponent("studyLevelsTable")
@LoadDataBeforeShow
public class StudyLevelBrowse extends StandardLookup<StudyLevel> {
}