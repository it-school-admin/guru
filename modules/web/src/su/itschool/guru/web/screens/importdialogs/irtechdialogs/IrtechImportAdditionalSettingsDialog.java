package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.IrTechImportAction;


import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportAdditionalSettingsDialog")
//TODO remove using descriptor
@UiDescriptor("irtech-import-additional-settings-dialog.xml")
public class IrtechImportAdditionalSettingsDialog extends Screen {


    private ImportSettings importSettings;

    @Subscribe("submitBtn")
    public void onSubmitBtnClick(Button.ClickEvent event) {
        close(new IrTechImportAction(SUBMITTED,fillMainSettingsAndReturn()));
    }

    private ImportSettings fillMainSettingsAndReturn() {
        return importSettings;
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportAction(CANCELLED));
    }

    public void setImportSettings(ImportSettings importSettings) {
        this.importSettings = importSettings;
    }
}