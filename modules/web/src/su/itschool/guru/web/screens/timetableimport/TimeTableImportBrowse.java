package su.itschool.guru.web.screens.timetableimport;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.entity.TimeTableImport;

import javax.inject.Inject;

import su.itschool.guru.service.ClearDBService;
import su.itschool.guru.service.ImportIrTechXMLToDBService;

@UiController("guru_TimeTableImport.browse")
@UiDescriptor("time-table-import-browse.xml")
@LookupComponent("timeTableImportsTable")
@LoadDataBeforeShow
public class TimeTableImportBrowse extends StandardLookup<TimeTableImport> {

    @Inject
    private ImportIrTechXMLToDBService importIrTechXMLToDBService;
    @Inject
    private CollectionContainer<TimeTableImport> timeTableImportsDc;
    @Inject
    private ClearDBService clearDBService;
    @Inject
    private CollectionContainer<LessonsGridType> lessonsGridTypesDc;

    @Subscribe("uploadFileBtn")
    public void onUploadFileBtnClick(Button.ClickEvent event) {
        importIrTechXMLToDBService.parseIrTechXML(timeTableImportsDc.getItem(), lessonsGridTypesDc.getItem());
    }

    @Subscribe("clearDBBtn")
    public void onClearDBBtnClick(Button.ClickEvent event) {
        clearDBService.clearDB();
    }
}