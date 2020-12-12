package su.itschool.guru.web.screens.lessonsgridtype;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridType;

@UiController("guru_LessonsGrid.browse")
@UiDescriptor("lessons-grid-type-browse.xml")
@LookupComponent("lessonsGridTypesTable")
@LoadDataBeforeShow
public class LessonsGridTypeBrowse extends StandardLookup<LessonsGridType> {
}