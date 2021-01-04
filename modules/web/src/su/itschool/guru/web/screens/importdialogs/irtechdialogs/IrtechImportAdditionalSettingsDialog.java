package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider.IrTechImportAction;


import javax.inject.Inject;

import static su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportAdditionalSettingsDialog")
//TODO remove using descriptor
@UiDescriptor("irtech-import-additional-settings-dialog.xml")
public class IrtechImportAdditionalSettingsDialog extends Screen {


    private ImportSettings importSettings;
    @Inject
    private CheckBox importLessonsGrid;
    @Inject
    private LookupPickerField<LessonsGridType> lessonsGridFieldForFirstShift;
    @Inject
    private LookupPickerField<LessonsGridType> lessonsGridFieldForSecondShift;
    @Inject
    private Dialogs dialogs;
    @Inject
    private CheckBox importSubjectsField;
    @Inject
    private CheckBox importTeachersField;
    @Inject
    private CheckBox importRoomsField;
    @Inject
    private CheckBox importStudyPlanField;
    @Inject
    private CheckBox importClassesField;

    @Subscribe("submitBtn")
    public void onSubmitBtnClick(Button.ClickEvent event) {
        if(importLessonsGridCheckedButGridTypeIsNotSpecified())
        {
            //todo localize
            dialogs.createMessageDialog()
                    .withCaption("Предупреждение")
                    .withMessage("Необходимо выбрать шаблон сетки уроков")
            .show();
        }
        else
        {
            close(new IrTechImportAction(SUBMITTED, fillAdditionalSettingsAndReturn()));
        }
    }

    private boolean importLessonsGridCheckedButGridTypeIsNotSpecified() {
        return importLessonsGrid.getValue()
                && lessonsGridFieldForFirstShift.getValue() == null
                && lessonsGridFieldForSecondShift.getValue() == null;
    }

    private ImportSettings fillAdditionalSettingsAndReturn() {
        importSettings.setImportLessonsGrid(getImportLessonsGrid());
        importSettings.setLessonsGridForFirstShift(lessonsGridFieldForFirstShift.getValue());
        importSettings.setLessonsGridForSecondShift(lessonsGridFieldForSecondShift.getValue());
        importSettings.setImportSubjects(importSubjectsField.getValue());
        importSettings.setImportTeachers(importTeachersField.getValue());
        importSettings.setImportRooms(importRoomsField.getValue());
        importSettings.setImportClasses(importClassesField.getValue());
        importSettings.setImportStudyPlan(importStudyPlanField.getValue());
        return importSettings;
    }

    private Boolean getImportLessonsGrid() {
        return importLessonsGrid.getValue();
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportAction(CANCELLED));
    }

    public void setImportSettings(ImportSettings importSettings) {
        this.importSettings = importSettings;
    }

    @Subscribe("importLessonsGrid")
    public void onImportLessonsGridValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        lessonsGridFieldForFirstShift.setEnabled(event.getValue());
        lessonsGridFieldForSecondShift.setEnabled(event.getValue());
    }
}