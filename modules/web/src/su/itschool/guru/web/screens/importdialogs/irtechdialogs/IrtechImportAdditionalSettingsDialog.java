package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.IrTechImportAction;


import javax.inject.Inject;

import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportAdditionalSettingsDialog")
//TODO remove using descriptor
@UiDescriptor("irtech-import-additional-settings-dialog.xml")
public class IrtechImportAdditionalSettingsDialog extends Screen {


    private ImportSettings importSettings;
    @Inject
    private CheckBox importLessonsGrid;
    @Inject
    private LookupPickerField<LessonsGridType> lessonsGridField;
    @Inject
    private Dialogs dialogs;

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
            close(new IrTechImportAction(SUBMITTED,fillMainSettingsAndReturn()));
        }
    }

    private boolean importLessonsGridCheckedButGridTypeIsNotSpecified() {
        return importLessonsGrid.getValue() && lessonsGridField.getValue() == null;
    }

    private ImportSettings fillMainSettingsAndReturn() {
        importSettings.setAdditionalData(getImportLessonsGrid());
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
        lessonsGridField.setEnabled(event.getValue());
    }
}