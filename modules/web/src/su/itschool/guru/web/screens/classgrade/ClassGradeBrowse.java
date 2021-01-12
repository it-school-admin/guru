package su.itschool.guru.web.screens.classgrade;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogActions;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassGrade;
import su.itschool.guru.service.GradesService;

import javax.inject.Inject;

import static com.haulmont.cuba.gui.app.core.inputdialog.DialogActions.OK_CANCEL;

@UiController("guru_ClassGrade.browse")
@UiDescriptor("class-grade-browse.xml")
@LookupComponent("classGradesTable")
@LoadDataBeforeShow
public class ClassGradeBrowse extends StandardLookup<ClassGrade> {
    @Inject
    private GradesService gradesService;
    @Inject
    private Dialogs dialogs;

    //TODO localize
    @Subscribe("createGradesBtn")
    public void onCreateGradesBtnClick(Button.ClickEvent event) {
        dialogs.createInputDialog(this)
                .withCaption("Создание параллелей")
                .withParameters(
                        InputParameter.intParameter("amount").withCaption("Количество параллелей").withDefaultValue(11)
                )
                .withActions(OK_CANCEL)
                .withCloseListener(closeEvent->{
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        this.createGrades(closeEvent.getValue("amount"));
                    }
                })
                .show();
    }

    private void createGrades(Integer amount) {
       // gradesService.createGrades();

    }
}