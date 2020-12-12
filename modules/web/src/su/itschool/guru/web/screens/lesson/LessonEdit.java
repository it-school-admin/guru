package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;

@UiController("guru_Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
@LoadDataBeforeShow
public class LessonEdit extends StandardEditor<Lesson> {
}