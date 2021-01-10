package su.itschool.guru.web.screens;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.entity.TimetableTemplate;
import su.itschool.guru.entity.enums.WeekDay;

import javax.inject.Inject;

@UiController("guru_TimetableMaking")
@UiDescriptor("timetable-making.xml")
public class TimetableMaking extends Screen {
    @Inject
    private CollectionLoader<SchoolClass> schoolClassesDl;
    @Inject
    private CollectionLoader<TimetableTemplate> timetableTemplatesDl;
    @Inject
    private LookupField<TimetableTemplate> timetableTemplateLookUpField;
    @Inject
    private LookupField<WeekDay> weekDayLookUpField;
    @Inject
    private CollectionLoader<TimeTableTemplateItem> timeTableTemplateItemsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        schoolClassesDl.load();
        timetableTemplatesDl.load();
    }

    @Subscribe("timetableTemplateLookUpField")
    public void onTimetableTemplateLookUpFieldValueChange(HasValue.ValueChangeEvent<TimetableTemplate> event) {
        tryToLoadTemplateItems();
    }

    private void tryToLoadTemplateItems() {
        if(timetableTemplateLookUpField.getValue() != null &&
                weekDayLookUpField.getValue() != null)
        {
            loadTemplateItems();
        }
    }

    private void loadTemplateItems() {
        timeTableTemplateItemsDl.setParameter("timetableTemplate", timetableTemplateLookUpField.getValue());
        timeTableTemplateItemsDl.setParameter("weekDay", weekDayLookUpField.getValue());
        timeTableTemplateItemsDl.load();
    }

    @Subscribe("weekDayLookUpField")
    public void onWeekDayLookUpFieldValueChange(HasValue.ValueChangeEvent<WeekDay> event) {
        tryToLoadTemplateItems();
        weekDayLookUpField.setEnabled(true);
    }

    @Subscribe("classesLookUpField")
    public void onClassesLookUpFieldValueChange(HasValue.ValueChangeEvent<SchoolClass> event) {
        timetableTemplateLookUpField.setEnabled(true);
    }
}