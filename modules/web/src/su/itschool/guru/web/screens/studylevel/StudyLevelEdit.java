package su.itschool.guru.web.screens.studylevel;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.StudyLevel;

@UiController("guru_StudyLevel.edit")
@UiDescriptor("study-level-edit.xml")
@EditedEntityContainer("studyLevelDc")
@LoadDataBeforeShow
public class StudyLevelEdit extends StandardEditor<StudyLevel> {
}