package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.screen.CloseAction;
import com.haulmont.cuba.gui.screen.Screen;
import su.itschool.guru.service.ImportIrTechXMLToDBService;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechImportAdditionalSettingsDialog;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechImportSecondDialog;

import static com.haulmont.cuba.gui.screen.OpenMode.DIALOG;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

public class IrTechImportSettingsProvider {

    public static final String IRTECH_FILE_IMPORT_DIALOG_ID = "guru_IrtechFileImportDialog";
    public static final String IRTECH_IMPORT_MAIN_SETTINGS_DIALOG_ID = "guru_IrtechImportAdditionalSettingsDialog";

    public enum ResultStatus {SUBMITTED, CANCELLED};

    public static class IrTechImportAction implements CloseAction{

        private ResultStatus actionResult;
        private ImportSettings importSettings;

        public IrTechImportAction(ResultStatus actionResult, ImportSettings importSettings) {
            this.actionResult = actionResult;
            this.importSettings = importSettings;
        }

        public IrTechImportAction(ResultStatus actionResult) {
            this.actionResult = actionResult;
        }

        public ImportSettings getImportSettings() {
            if(actionResult == SUBMITTED)
            {
                return importSettings;
            }
            else
            {
                //TODO text
                throw new IllegalStateException();
            }
        }

        public ResultStatus getActionResult() {
            return actionResult;
        }
    }


    private Screens screens;
    private ImportIrTechXMLToDBService importIrTechXMLToDBService;
    private IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog;

    public IrTechImportSettingsProvider(Screens screens,
                                        ImportIrTechXMLToDBService importIrTechXMLToDBService,
                                        IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog)
    {
        this.screens = screens;
        this.importIrTechXMLToDBService = importIrTechXMLToDBService;
        this.irTechXMLClassesExtractorForDialog = irTechXMLClassesExtractorForDialog;
    }

    public void startImport() {
        askToLoadFile();
   }

    private void askToLoadFile() {
        Screen irtechFileImportDialog = screens.create(IRTECH_FILE_IMPORT_DIALOG_ID, DIALOG);

        irtechFileImportDialog.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();

            if(closeAction instanceof IrTechImportSettingsProvider.IrTechImportAction)
            {
                IrTechImportAction importAction = (IrTechImportAction) closeAction;
                if(importAction.getActionResult() == SUBMITTED)
                {
                    ImportSettings importSettings = importAction.getImportSettings();
                    if (!importSettings.getImportAllClasses())
                    {
                        askAboutSchoolClasses(importSettings);
                    }
                    else if(importSettings.getImportAdditionalData())
                    {
                        askAboutAdditionalSettings(importSettings);
                    }
                    else {
                        startImportProcess(importSettings);
                    }
                }
            }

        });
        irtechFileImportDialog.show();
    }

    private void askAboutAdditionalSettings(ImportSettings importSettings) {
        IrtechImportAdditionalSettingsDialog irtechImportAdditionalSettingsDialog
                = (IrtechImportAdditionalSettingsDialog) screens.create(IRTECH_IMPORT_MAIN_SETTINGS_DIALOG_ID, DIALOG);

        irtechImportAdditionalSettingsDialog.setImportSettings(importSettings);

        irtechImportAdditionalSettingsDialog.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();

            if(closeAction instanceof IrTechImportAction)
            {
                IrTechImportAction importAction = (IrTechImportAction) closeAction;
                if(importAction.getActionResult() == SUBMITTED)
                {
                       startImportProcess(importAction.getImportSettings());
                }
            }

        });
        irtechImportAdditionalSettingsDialog.show();
    }

    private void askAboutSchoolClasses(ImportSettings importSettings) {
        IrtechImportSecondDialog irtechImportSecondDialog
                = (IrtechImportSecondDialog) screens.create("guru_IrtechImportSecondDialog", DIALOG);
        irtechImportSecondDialog.setSettingsFromFirstDialog(importSettings);
        irtechImportSecondDialog.setIrTechXMLClassesExtractorForDialog(irTechXMLClassesExtractorForDialog);
        irtechImportSecondDialog.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();

            if(closeAction instanceof IrTechImportAction)
            {
                IrTechImportAction importAction = (IrTechImportAction) closeAction;
                if(importAction.getActionResult() == SUBMITTED)
                {
                    ImportSettings importSettingsFromAction = importAction.getImportSettings();
                    if(importSettingsFromAction.getImportAdditionalData())
                    {
                        askAboutAdditionalSettings(importSettingsFromAction);
                    }
                    else {
                        startImportProcess(importSettingsFromAction);
                    }
                }
            }
        });
        irtechImportSecondDialog.show();
    }

    private void startImportProcess(ImportSettings importSettings) {
        importIrTechXMLToDBService.importData(importSettings);
    }
}
