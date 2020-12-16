package su.itschool.guru.web.screens.lessonsgriditem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridItem;

@UiController("guru_LessonsGridItem.edit")
@UiDescriptor("lessons-grid-item-edit.xml")
@EditedEntityContainer("lessonsGridItemDc")
@LoadDataBeforeShow
public class LessonsGridItemEdit extends StandardEditor<LessonsGridItem> {
}