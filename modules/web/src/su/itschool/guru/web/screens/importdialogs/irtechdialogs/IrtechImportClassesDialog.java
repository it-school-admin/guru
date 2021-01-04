package su.itschool.guru.web.screens.importdialogs.irtechdialogs;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider;
import su.itschool.guru.web.importproviders.irtech.SchoolClassWrapper;

import javax.inject.Inject;
import java.util.*;

import static su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider.ResultStatus.CANCELLED;
import static su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider.ResultStatus.SUBMITTED;

@UiController("guru_IrtechImportClassesDialog")
@UiDescriptor("irtech-import-classes-dialog.xml")
public class IrtechImportClassesDialog extends Screen {
    public static final String GRADE_CHECK_BOX_ID_PREFIX = "grade_check_box_";
    private ImportSettings importSettings;
    private Map<Integer, CheckBox> classCheckBoxesMap = new HashMap<>();
    @Inject
    private UiComponents uiComponents;
    @Inject
    private GridLayout classesCheckBoxesGrid;

    private Map<Integer, List<SchoolClassWrapper>> gradesToClassesData = new HashMap();
    private Map<Integer, List<CheckBox>> gradesToClassesCheckBoxes = new HashMap();
    private List<CheckBox> gradeCheckBoxes = new ArrayList();
    private Set<Integer> selectedClassesIds = new HashSet();
    @Inject
    private Dialogs dialogs;
    private List<SchoolClassWrapper> schoolClassWrappers;

    public void setSettingsFromFirstDialog(ImportSettings importSettings) {
        this.importSettings = importSettings;
    }

    @Subscribe("importBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
        if(selectedClassesIds.isEmpty())
        {
            dialogs.createMessageDialog()
                    .withCaption("Предупреждение")
                    .withMessage("Необходимо выбрать хотя бы один класс")
                    .show();
        }
        else
        {
            close(new IrTechImportSettingsProvider.IrTechImportAction(SUBMITTED,addClassesToImportSettingsAndReturn()));
        }
    }

    private ImportSettings addClassesToImportSettingsAndReturn() {
        importSettings.setSelectedClasses(selectedClassesIds);
        return importSettings;
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(new IrTechImportSettingsProvider.IrTechImportAction(CANCELLED));
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        for(SchoolClassWrapper wrapper: schoolClassWrappers)
        {
            Integer grade = wrapper.getGrade();
            gradesToClassesData.putIfAbsent(grade, new ArrayList());
            gradesToClassesData.get(grade).add(wrapper);
        }

        classesCheckBoxesGrid.setColumns(2);
        classesCheckBoxesGrid.setRows(gradesToClassesData.size());

        int rowNumber=0;
        for (Map.Entry<Integer, List<SchoolClassWrapper>> entry: gradesToClassesData.entrySet())
        {
            createTableRow(rowNumber, entry.getKey(),entry.getValue());
            rowNumber++;
        }

    }

    private void createTableRow(int rowNumber, Integer grade, List<SchoolClassWrapper> classes) {

        ComponentContainer container = createRowAndGetContainer(rowNumber, grade);
        for (SchoolClassWrapper classWrapper: classes)
        {
            CheckBox classCheckBox = createClassCheckBox(container, classWrapper);
            classCheckBoxesMap.put(classWrapper.getClassId(), classCheckBox);
            putToGradesCheckBoxesMap(grade, classCheckBox);
        }
    }

    private void putToGradesCheckBoxesMap(Integer grade, CheckBox classCheckBox) {
        gradesToClassesCheckBoxes.putIfAbsent(grade, new ArrayList());
        gradesToClassesCheckBoxes.get(grade).add(classCheckBox);
    }

    private ComponentContainer createRowAndGetContainer(int rowNumber, Integer grade) {

        CheckBox gradeSelectionCheckBox = createGradeSelectionCheckBox(grade);
        classesCheckBoxesGrid.add(gradeSelectionCheckBox, 0, rowNumber);
        gradeCheckBoxes.add(gradeSelectionCheckBox);

        ComponentContainer container = createContainerForCheckBoxes(HBoxLayout.NAME);
        classesCheckBoxesGrid.add(container, 1, rowNumber);
        classesCheckBoxesGrid.setSizeAuto();
        return container;
    }

    private CheckBox createGradeSelectionCheckBox(Integer grade) {
        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setId(GRADE_CHECK_BOX_ID_PREFIX + grade);
        checkBox.addValueChangeListener(event->{
            Boolean checked = event.getValue();
            for (CheckBox classCheckBox: gradesToClassesCheckBoxes.get(grade))
            {
                classCheckBox.setValue(checked);
            }

        });
        //todo localize
        checkBox.setCaption(grade + "-е классы");
        return checkBox;
    }

    private ComponentContainer createContainerForCheckBoxes(String name) {
        ComponentContainer container = uiComponents.create(name);
        container.setWidth("100%");
        container.setHeight("100%");
        return container;
    }

    private CheckBox createClassCheckBox(ComponentContainer parentContainer, SchoolClassWrapper classWrapper) {
        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setId("schoolClassCheckBox_"+classWrapper.getClassId().toString());
        checkBox.setCaption(classWrapper.getClassName());
        checkBox.addValueChangeListener(event->{
            if(event.getValue())
            {
                selectedClassesIds.add(classWrapper.getClassId());
            }
            else
            {
                selectedClassesIds.remove(classWrapper.getClassId());
            }
        });
        parentContainer.add(checkBox);
        return checkBox;
    }

    private void setSelectionForGradesCheckBoxes(boolean selected) {
        for(CheckBox gradeSelectionCheckBox: gradeCheckBoxes)
        {
            gradeSelectionCheckBox.setValue(selected);
        }
    }

    private void setSelectionForClassesCheckBoxes(boolean selected) {
        for(Map.Entry<Integer, CheckBox> checkBoxEntry: classCheckBoxesMap.entrySet())
        {
            checkBoxEntry.getValue().setValue(selected);
        }
    }

    @Subscribe("selectAllBtn")
    public void onSelectAllBtnClick(Button.ClickEvent event) {
        setSelectionForClassesCheckBoxes(true);
        setSelectionForGradesCheckBoxes(true);
    }

    @Subscribe("unselectAllClasses")
    public void onUnselectAllClassesClick(Button.ClickEvent event) {
        setSelectionForClassesCheckBoxes(false);
        setSelectionForGradesCheckBoxes(false);
    }

    public void setSchoolClassWrappers(List<SchoolClassWrapper> schoolClassWrappers) {

        this.schoolClassWrappers = schoolClassWrappers;
    }
}