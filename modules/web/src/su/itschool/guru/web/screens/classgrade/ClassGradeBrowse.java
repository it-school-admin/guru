package su.itschool.guru.web.screens.classgrade;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassGrade;
import su.itschool.guru.entity.StudyLevel;
import su.itschool.guru.entity.enums.PlanningType;
import su.itschool.guru.service.GradesService;
import su.itschool.guru.web.bulkcreation.BulkCreationNotifier;

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
    @Inject
    private CollectionLoader<ClassGrade> classGradesDl;
    @Inject
    private Notifications notifications;

    //TODO localize
    @Subscribe("createGradesBtn")
    public void onCreateGradesBtnClick(Button.ClickEvent event) {
        dialogs.createInputDialog(this)
                .withCaption("Создание параллелей")
                .withParameters(
                        InputParameter.intParameter("from").withCaption("Начиная с").withDefaultValue(1).withRequired(true),
                        InputParameter.intParameter("to").withCaption("заканчивая").withDefaultValue(11).withRequired(true),
                        InputParameter.entityParameter("level", StudyLevel.class).withCaption("Уровень образования").withRequired(true),
                        InputParameter.enumParameter("planningType", PlanningType.class).withCaption("Тип планирования").withRequired(true)
                )
                .withActions(OK_CANCEL)
                .withCloseListener(closeEvent->{
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        this.createGrades(
                                closeEvent.getValue("from"),
                                closeEvent.getValue("to"),
                                closeEvent.getValue("level"),
                                closeEvent.getValue("planningType")
                                );
                    }
                })
                .show();
    }

    private void createGrades(Integer from, Integer to, StudyLevel level, PlanningType planningType) {
        new BulkCreationNotifier(notifications).showBulkCreationResult(gradesService.createGrades(from, to, level, planningType));
        classGradesDl.load();
    }
}