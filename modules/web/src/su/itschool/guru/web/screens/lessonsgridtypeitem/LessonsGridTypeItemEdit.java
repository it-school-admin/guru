package su.itschool.guru.web.screens.lessonsgridtypeitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridTypeItem;

@UiController("guru_LessonsGridTypeItem.edit")
@UiDescriptor("lessons-grid-type-item-edit.xml")
@EditedEntityContainer("lessonsGridTypeItemDc")
@LoadDataBeforeShow
public class LessonsGridTypeItemEdit extends StandardEditor<LessonsGridTypeItem> {
}