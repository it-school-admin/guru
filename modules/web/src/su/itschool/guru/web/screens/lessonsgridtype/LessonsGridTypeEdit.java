package su.itschool.guru.web.screens.lessonsgridtype;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridType;

@UiController("guru_LessonsGrid.edit")
@UiDescriptor("lessons-grid-type-edit.xml")
@EditedEntityContainer("lessonsGridTypeDc")
@LoadDataBeforeShow
public class LessonsGridTypeEdit extends StandardEditor<LessonsGridType> {
}