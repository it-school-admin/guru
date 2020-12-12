package su.itschool.guru.web.screens.lessonsplanningitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsPlanningItem;

@UiController("guru_LessonsPlanningItem.browse")
@UiDescriptor("lessons-planning-item-browse.xml")
@LookupComponent("lessonsPlanningItemsTable")
@LoadDataBeforeShow
public class LessonsPlanningItemBrowse extends StandardLookup<LessonsPlanningItem> {
}