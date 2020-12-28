package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;

@UiController("guru_Lesson.browse-for-dispatcher")
@UiDescriptor("lesson-browse-for-dispatcher.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowseForDispatcher extends StandardLookup<Lesson> {
    @Subscribe("ImportBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
 //TODO       InputParameter.fileParameter()

    }
}