package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogActions;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;

import javax.inject.Inject;

import static com.haulmont.cuba.gui.app.core.inputdialog.DialogActions.OK_CANCEL;
import static com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome.OK;

@UiController("guru_Lesson.browse-for-dispatcher")
@UiDescriptor("lesson-browse-for-dispatcher.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowseForDispatcher extends StandardLookup<Lesson> {
    @Inject
    private Dialogs dialogs;

    @Subscribe("ImportBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
        ImportSettings importSettings = new ImportSettings();

        dialogs.createInputDialog(this)
               .withCaption("Мастер импортирования данных из ИрТех")
               .withParameters(InputParameter.fileParameter("filename"))
               .withActions(OK_CANCEL)
               .withCloseListener(closeEvent->{
                   if(closeEvent.closedWith(OK))
                   {
                       importSettings.filename = closeEvent.getValue("filename");
                   }
               })
               .show();
        //dialogs.createOptionDialog()

    }
}