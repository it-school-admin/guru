package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;

@UiController("guru_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
}