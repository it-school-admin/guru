package su.itschool.guru.web.screens.groupforlesson;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.GroupForLesson;

@UiController("guru_GroupForLesson.browse")
@UiDescriptor("group-for-lesson-browse.xml")
@LookupComponent("groupForLessonsTable")
@LoadDataBeforeShow
public class GroupForLessonBrowse extends StandardLookup<GroupForLesson> {
}