package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.IrTechImportAction;
import su.itschool.guru.web.screens.lesson.IrTechXMLClassesExtractorForDialog;

import javax.inject.Inject;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechFileImportDialog")
@UiDescriptor("irtech-main-Import-dialog.xml")
public class IrtechMainImportDialog extends Screen {
    private FileDescriptor importedFileDescriptor;

    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private FileUploadField importedFileField;
    @Inject
    private TextField<String> timeTableTemplateNameField;
    @Inject
    private CheckBox importAllClasses;
    @Inject
    private CheckBox importAdditionalData;
    @Inject
    private Button submitBtn;
    @Inject
    private Dialogs dialogs;
    @Inject
    private DataManager dataManager;
    private IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog;
    @Deprecated
    private List<IrTechXMLClassesExtractorForDialog.SchoolClassWrapper> schoolClassWrappers;

    private ImportSettings createImportSettings() {
        ImportSettings importSettings = new ImportSettings(importedFileDescriptor,
                getScheduleName(),
                getImportAllClasses(),
                getImportAdditionalData());

        return importSettings;
    }

    private Boolean getImportAdditionalData() {
        return importAdditionalData.getValue();
    }

    private Boolean getImportAllClasses() {
        return importAllClasses.getValue();
    }

    private String getScheduleName() {
        return timeTableTemplateNameField.getValue();
    }

    @Subscribe("importedFileField")
    public void onImportedFileFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        processFile();
        submitBtn.setEnabled(true);
    }

    private void processFile() {
        UUID fileId = importedFileField.getFileId();
        String fileName = importedFileField.getFileName();
        FileDescriptor fileDescriptor = fileUploadingAPI.getFileDescriptor(fileId, fileName);
        File importedFile = fileUploadingAPI.getFile(fileId);

        schoolClassWrappers
                = irTechXMLClassesExtractorForDialog.extractSchoolClassesData(importedFile);
        try {
            fileUploadingAPI.putFileIntoStorage(fileId, fileDescriptor);
            dataManager.commit(fileDescriptor);
            importedFileDescriptor = fileDescriptor;
        } catch (FileStorageException e) {
            //TODO message
            throw new RuntimeException(e);
        }
    }

    @Subscribe("submitBtn")
    public void onSubmitBtnClick(Button.ClickEvent event) {
        if(timeTableTemplateNameField.isEmpty())
        {
            dialogs.createMessageDialog()
                    .withCaption("Предупреждение")
                    .withMessage("Необходимо указать имя шаблона расписания для загрузки")
                    .show();
        }
        else
        {
            close(new IrTechImportAction(SUBMITTED,createImportSettings(), schoolClassWrappers));
        }
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportAction(CANCELLED));
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        submitBtn.setEnabled(false);
        timeTableTemplateNameField.setValue("Шаблон расписания ИрТех " + LocalDateTime.now().toString());
    }

    @Subscribe("importedFileField")
    public void onImportedFileFieldBeforeValueClear(FileUploadField.BeforeValueClearEvent event) {
        submitBtn.setEnabled(false);
        //TODO localize
    }

    public void setIrTechXMLClassesExtractorForDialog(IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog) {
        this.irTechXMLClassesExtractorForDialog = irTechXMLClassesExtractorForDialog;
    }
}