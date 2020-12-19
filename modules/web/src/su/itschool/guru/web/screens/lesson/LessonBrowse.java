package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.entity.Week;
import su.itschool.guru.service.CopyTimeTableForWeekFromTemplateService;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("guru_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
    @Inject
    private CopyTimeTableForWeekFromTemplateService copyTimeTableForWeekFromTemplateService;
    @Inject
    private CollectionContainer<Week> weeksDc;
    @Inject
    private Calendar<LocalDateTime> lessonsCalendar;

    @Subscribe("loadFromTemplate")
    public void onLoadFromTemplateClick(Button.ClickEvent event) {
        copyTimeTableForWeekFromTemplateService.copyTimeTableForWeekFromTemplate(weeksDc.getItem(), true);
    }

    @Subscribe("clearWeek")
    public void onClearWeekClick(Button.ClickEvent event) {
        copyTimeTableForWeekFromTemplateService.clearWeek(weeksDc.getItem());
    }

    @Subscribe("clearAllWeeks")
    public void onClearAllWeeksClick(Button.ClickEvent event) {
        copyTimeTableForWeekFromTemplateService.clearAllWeeks();

    }

    @Subscribe("weeksTable")
    public void onWeeksTableSelection(Table.SelectionEvent<Week> event) {
        Week selectedWeek = weeksDc.getItem();
        lessonsCalendar.setStartDate(selectedWeek.getStartDate().atStartOfDay());
        lessonsCalendar.setEndDate(selectedWeek.getEndDate().atStartOfDay());
    }

    @Subscribe("lessonsCalendar")
    public void onLessonsCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent<LocalDateTime> event) {
      /*  lessonsCalendar.
        event.getEntity().*/
    }
}