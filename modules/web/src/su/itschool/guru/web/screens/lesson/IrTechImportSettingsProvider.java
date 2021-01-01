package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.screen.CloseAction;
import com.haulmont.cuba.gui.screen.Screen;
import su.itschool.guru.service.ImportIrTechXMLToDBService;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.importdialogs.irtechdialogs.IrtechImportSecondDialog;

import static com.haulmont.cuba.gui.screen.OpenMode.DIALOG;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

public class IrTechImportSettingsProvider {

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

        Screen irtechImportFirstDialog = screens.create("guru_IrtechImportFirstDialog", DIALOG);

        irtechImportFirstDialog.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();

            if(closeAction instanceof IrTechImportSettingsProvider.IrTechImportAction)
            {
                IrTechImportAction importAction = (IrTechImportAction) closeAction;
                if(importAction.getActionResult() == SUBMITTED)
                {
                    askAboutSchoolClassesAndImportIfNeed(importAction.getImportSettings());
                }
            }

        });
        irtechImportFirstDialog.show();
    }

    private void askAboutSchoolClassesAndImportIfNeed(ImportSettings importSettings) {
        IrtechImportSecondDialog irtechImportSecondDialog = (IrtechImportSecondDialog) screens.create("guru_IrtechImportSecondDialog", DIALOG);
        irtechImportSecondDialog.setSettingsFromFirstDialog(importSettings);
        irtechImportSecondDialog.setIrTechXMLClassesExtractorForDialog(irTechXMLClassesExtractorForDialog);
        irtechImportSecondDialog.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();

            if(closeAction instanceof IrTechImportAction)
            {
                IrTechImportAction importAction = (IrTechImportAction) closeAction;
                if(importAction.getActionResult() == SUBMITTED)
                {
                    importIrTechXMLToDBService.importData(importAction.getImportSettings());
                }
            }
        });
        irtechImportSecondDialog.show();
    }
}
