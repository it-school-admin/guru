package su.itschool.guru.web.screens.lessonsgridtypeitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridTypeItem;

@UiController("guru_LessonsGridTypeItem.browse")
@UiDescriptor("lessons-grid-type-item-browse.xml")
@LookupComponent("lessonsGridTypeItemsTable")
@LoadDataBeforeShow
public class LessonsGridTypeItemBrowse extends StandardLookup<LessonsGridTypeItem> {
}