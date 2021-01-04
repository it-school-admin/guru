package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.service.ImportIrTechXMLToDBService;
import su.itschool.guru.web.importproviders.irtech.IrTechImportSettingsProvider;
import su.itschool.guru.web.importproviders.irtech.IrTechXMLClassesExtractorForDialog;

import javax.inject.Inject;


@UiController("guru_Lesson.browse-for-dispatcher")
@UiDescriptor("lesson-browse-for-dispatcher.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowseForDispatcher extends StandardLookup<Lesson> {
    @Inject
    private ImportIrTechXMLToDBService importIrTechXMLToDBService;
    @Inject
    private Screens screens;
    @Inject
    private Notifications notifications;

    @Subscribe("ImportBtn")
    public void onImportBtnClick(Button.ClickEvent event) {
        new IrTechImportSettingsProvider(screens,
                importIrTechXMLToDBService,
                new IrTechXMLClassesExtractorForDialog(),
                notifications)
            .startImport();
    }


}