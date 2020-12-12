package su.itschool.guru.web.screens.groupforlesson;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.GroupForLesson;

@UiController("guru_GroupForLesson.edit")
@UiDescriptor("group-for-lesson-edit.xml")
@EditedEntityContainer("groupForLessonDc")
@LoadDataBeforeShow
public class GroupForLessonEdit extends StandardEditor<GroupForLesson> {
}