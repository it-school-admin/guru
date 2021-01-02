package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

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
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider;

import javax.inject.Inject;
import java.io.File;
import java.time.LocalDateTime;

import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechFileImportDialog")
@UiDescriptor("irtech-main-Import-dialog.xml")
public class IrtechMainImportDialog extends Screen {
    private File importedFile;

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

    private ImportSettings createImportSettings() {
        ImportSettings importSettings = new ImportSettings(importedFile,
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
        importedFile = fileUploadingAPI.getFile(importedFileField.getFileId());
        submitBtn.setEnabled(true);
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
            close(new IrTechImportSettingsProvider.IrTechImportAction(SUBMITTED,createImportSettings()));
        }
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportSettingsProvider.IrTechImportAction(CANCELLED));
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
}