package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.ImportIrTechXMLToDBService;

import javax.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.haulmont.cuba.gui.app.core.inputdialog.DialogActions.OK_CANCEL;
import static com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome.OK;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@UiController("guru_Lesson.browse-for-dispatcher")
@UiDescriptor("lesson-browse-for-dispatcher.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowseForDispatcher extends StandardLookup<Lesson> {
    @Inject
    private Dialogs dialogs;
    @Inject
    private ImportIrTechXMLToDBService importIrTechXMLToDBService;

    @Subscribe("ImportBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
        ImportSettings importSettings = new ImportSettings();
        LessonBrowseForDispatcher mainFrame = this;

        dialogs.createInputDialog(mainFrame)
               .withCaption("Мастер импортирования данных из ИрТех")
               .withParameters(
                       //todo change to localized captions
                       InputParameter.fileParameter("importFile").withCaption("Файл выгрузки разписания из ИрТех"),
                       InputParameter.entityParameter("lessonsGrid", LessonsGridType.class).withCaption("Сетка уроков"),
                       InputParameter.booleanParameter("importLessonsGrid").withCaption("Импортировать сетку уроков").withDefaultValue(FALSE),
                       InputParameter.booleanParameter("importSubjects").withCaption("Импортировать предметы").withDefaultValue(FALSE),
                       InputParameter.booleanParameter("importTeachers").withCaption("Импортировать данные об учителях").withDefaultValue(FALSE),
                       InputParameter.booleanParameter("importRooms").withCaption("Импортировать данные об аудиториях").withDefaultValue(FALSE),
                       InputParameter.booleanParameter("importClasses").withCaption("Импортировать данные о классах").withDefaultValue(FALSE),
                       InputParameter.booleanParameter("importStudyPlan").withCaption("Импортировать учебный план").withDefaultValue(FALSE),
                       InputParameter.stringParameter("lessonsTemplateName").withCaption("Импортировать шаблон расписания на неделю").withDefaultValue("ИрТех" + getTimeStamp()),
                       InputParameter.booleanParameter("importLessonsTemplate").withCaption("Импортировать шаблон расписания на неделю").withDefaultValue(TRUE)
               )
               .withActions(OK_CANCEL)
               .withWidth("800px")
               .withHeight("450px")
               .withCloseListener(closeEvent->{
                   if(closeEvent.closedWith(OK))
                   {
                       fillFirstSettingsAndRequestMoreIfNeed(importSettings, closeEvent, mainFrame);

//                       importIrTechXMLToDBService.parseIrTechXML()
                   }
               })
               .show();

    }

    private void fillFirstSettingsAndRequestMoreIfNeed(ImportSettings importSettings, InputDialog.InputDialogCloseEvent closeEvent, LessonBrowseForDispatcher mainFrame) {
        importSettings.importFile = closeEvent.getValue("filename");

        dialogs.createInputDialog(mainFrame)
                .withCaption("Выберите классы для загрузки шаблона расписания")
                .withParameters(createClassesCheckBoxes(getClassesNamesIrTechIdsMapFromImportFile(importSettings.importFile)))
                .show();
    }

    private InputParameter[] createClassesCheckBoxes(Map<Integer, String> classesIrTechIdsToClassesNamesMapFromImportFile) {
        List<InputParameter> inputParameters = new ArrayList<>();

        for(Map.Entry<Integer, String> classData: classesIrTechIdsToClassesNamesMapFromImportFile.entrySet())
        {
            inputParameters.add(
                    InputParameter.booleanParameter("classInput_"+classData.getKey().toString())
                            .withCaption(classData.getValue())
                            .withDefaultValue(TRUE));
        }
        return inputParameters.toArray(new InputParameter[0]);
    }

    private Map<Integer, String> getClassesNamesIrTechIdsMapFromImportFile(FileDescriptor importFile) {
        return new IrTechXMLClassesExtractorForDialog().extractSchoolClassesIdsToClassesNamesMap(importFile);
    }

    private String getTimeStamp() {
        return LocalDateTime.now().toString();
    }
}