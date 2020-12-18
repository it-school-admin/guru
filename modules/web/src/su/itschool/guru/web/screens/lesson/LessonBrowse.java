package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.entity.Week;
import su.itschool.guru.service.CopyTimeTableForWeekFromTemplateService;

import javax.inject.Inject;

@UiController("guru_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
    @Inject
    private CopyTimeTableForWeekFromTemplateService copyTimeTableForWeekFromTemplateService;
    @Inject
    private CollectionContainer<Week> weeksDc;

    @Subscribe("loadFromTemplate")
    public void onLoadFromTemplateClick(Button.ClickEvent event) {
        copyTimeTableForWeekFromTemplateService.copyTimeTableForWeekFromTemplate(weeksDc.getItem(), true);
    }
}