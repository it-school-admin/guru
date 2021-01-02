package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.screen.CloseAction;
import com.haulmont.cuba.gui.screen.Screen;
import su.itschool.guru.service.ImportIrTechXMLToDBService;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechImportAdditionalSettingsDialog;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechImportClassesDialog;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechMainImportDialog;
import su.itschool.guru.web.screens.lesson.IrTechXMLClassesExtractorForDialog.SchoolClassWrapper;

import java.io.File;
import java.util.List;

import static com.haulmont.cuba.gui.screen.OpenMode.DIALOG;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

public class IrTechImportSettingsProvider {

    public static final String IRTECH_FILE_IMPORT_DIALOG_ID = "guru_IrtechFileImportDialog";
    public static final String IRTECH_IMPORT_MAIN_SETTINGS_DIALOG_ID = "guru_IrtechImportAdditionalSettingsDialog";
    public static final String IRTECH_IMPORT_CLASSES_DIALOG_ID = "guru_IrtechImportClassesDialog";

    public enum ResultStatus {SUBMITTED, CANCELLED};

    public static class IrTechImportAction implements CloseAction{

        private final ResultStatus actionResult;
        private final ImportSettings importSettings;
        private List<SchoolClassWrapper> schoolClassWrappers;

        public IrTechImportAction(ResultStatus actionResult, ImportSettings importSettings) {
            this.actionResult = actionResult;
            this.importSettings = importSettings;
        }


        public IrTechImportAction(ResultStatus actionResult) {
            this(actionResult, null);
        }

        public IrTechImportAction(ResultStatus actionResult,
                                  ImportSettings importSettings,
                                  List<SchoolClassWrapper> schoolClassWrappers) {
            this(actionResult, importSettings);
            this.schoolClassWrappers = schoolClassWrappers;
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

        public List<SchoolClassWrapper> getSchoolClassWrappers() {
            return schoolClassWrappers;
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
        IrtechMainImportDialog irtechFileImportDialog
                = (IrtechMainImportDialog) screens.create(IRTECH_FILE_IMPORT_DIALOG_ID, DIALOG);
        irtechFileImportDialog.setIrTechXMLClassesExtractorForDialog(irTechXMLClassesExtractorForDialog);

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
                        askAboutSchoolClasses(importSettings, importAction.getSchoolClassWrappers());
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

    private void askAboutSchoolClasses(ImportSettings importSettings, List<SchoolClassWrapper> schoolClassWrappers) {
        IrtechImportClassesDialog irtechImportClassesDialog
                = (IrtechImportClassesDialog) screens.create(IRTECH_IMPORT_CLASSES_DIALOG_ID, DIALOG);
        irtechImportClassesDialog.setSettingsFromFirstDialog(importSettings);
        irtechImportClassesDialog.setSchoolClassWrappers(schoolClassWrappers);
        irtechImportClassesDialog.addAfterCloseListener(afterCloseEvent -> {
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
        irtechImportClassesDialog.show();
    }

    private void startImportProcess(ImportSettings importSettings) {
        importIrTechXMLToDBService.importData(importSettings);
    }
}
