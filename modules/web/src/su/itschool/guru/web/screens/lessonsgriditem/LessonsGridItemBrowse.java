package su.itschool.guru.web.screens.lessonsgriditem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridItem;

@UiController("guru_LessonsGridItem.browse")
@UiDescriptor("lessons-grid-item-browse.xml")
@LookupComponent("lessonsGridItemsTable")
@LoadDataBeforeShow
public class LessonsGridItemBrowse extends StandardLookup<LessonsGridItem> {
}