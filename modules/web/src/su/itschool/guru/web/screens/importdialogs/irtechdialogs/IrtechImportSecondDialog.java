package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider;
import su.itschool.guru.web.screens.lesson.IrTechXMLClassesExtractorForDialog;
import su.itschool.guru.web.screens.lesson.IrTechXMLClassesExtractorForDialog.SchoolClassWrapper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.screens.lesson.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportSecondDialog")
@UiDescriptor("irTech-import-second-dialog.xml")
public class IrtechImportSecondDialog extends Screen {
    private ImportSettings importSettings;
    private IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog;
    private Map<Integer, CheckBox> classCheckBoxesMap = new HashMap<>();
    @Inject
    private UiComponents uiComponents;
    @Inject
    private VBoxLayout classesBox;


    public void setSettingsFromFirstDialog(ImportSettings importSettings) {
        this.importSettings = importSettings;
    }

    @Subscribe("importBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
        close(new IrTechImportSettingsProvider.IrTechImportAction(SUBMITTED,addClassesToImportSettingsAndReturn()));
    }

    private ImportSettings addClassesToImportSettingsAndReturn() {
        return importSettings;
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportSettingsProvider.IrTechImportAction(CANCELLED));
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        List<SchoolClassWrapper> schoolClassWrappers = irTechXMLClassesExtractorForDialog.extractSchoolClassesData(importSettings.importedFile);
        for(SchoolClassWrapper wrapper: schoolClassWrappers)
        {
            classCheckBoxesMap.put(wrapper.getClassId(), createCheckBox(wrapper.getClassId(), wrapper.getClassName()));
        }
    }

    private CheckBox createCheckBox(Integer classId, String className) {
        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        //checkBox.setParent(classesBox);
        checkBox.setId("schoolClassCheckBox_"+classId.toString());
        checkBox.setCaption(className);
        checkBox.setVisible(true);
        checkBox.setEnabled(true);
        checkBox.setValue(false);
        classesBox.add(checkBox);
        return checkBox;
    }

    public void setIrTechXMLClassesExtractorForDialog(IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog) {

        this.irTechXMLClassesExtractorForDialog = irTechXMLClassesExtractorForDialog;
    }

    @Subscribe("selectAllCheckBox")
    public void onSelectAllCheckBoxValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        for(Map.Entry<Integer, CheckBox> checkBoxEntry: classCheckBoxesMap.entrySet())
        {
            checkBoxEntry.getValue().setValue(event.getValue());
        }

    }
}