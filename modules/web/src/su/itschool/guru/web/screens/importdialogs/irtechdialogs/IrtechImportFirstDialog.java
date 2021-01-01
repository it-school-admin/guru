package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.IrTechImportAction;

import javax.inject.Inject;

import java.io.File;

import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportFirstDialog")
//TODO remove using descriptor
@UiDescriptor("irTech-import-first-dialog.xml")
public class IrtechImportFirstDialog extends Screen {

    private File importedFile;

    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private FileUploadField importedFileField;

    @Subscribe("submitBtn")
    public void onSubmitBtnClick(Button.ClickEvent event) {
        //importedFile.getFileDescriptor();
        close(new IrTechImportAction(SUBMITTED,createImportSettings()));
    }

    private ImportSettings createImportSettings() {
        ImportSettings importSettings = new ImportSettings();
        importSettings.importedFile = this.importedFile;
        return importSettings;
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportAction(CANCELLED));
    }

    @Subscribe("importedFileField")
    public void onImportedFileFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        importedFile = fileUploadingAPI.getFile(importedFileField.getFileId());
    }

}