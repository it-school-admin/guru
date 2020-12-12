package su.itschool.guru.web.screens.lessonsplanningitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsPlanningItem;

@UiController("guru_LessonsPlanningItem.edit")
@UiDescriptor("lessons-planning-item-edit.xml")
@EditedEntityContainer("lessonsPlanningItemDc")
@LoadDataBeforeShow
public class LessonsPlanningItemEdit extends StandardEditor<LessonsPlanningItem> {
}