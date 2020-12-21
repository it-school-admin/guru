package su.itschool.guru.listeners;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeDetachEntityListener;
import org.springframework.stereotype.Component;
import su.itschool.guru.entity.Lesson;
import su.itschool.guru.service.CalendarService;

import javax.inject.Inject;

@Component("guru_LessonDetachListener")
public class BeforeDetachLessonEntityListener implements BeforeDetachEntityListener<Lesson> {
    @Inject
    private CalendarService calendarService;

    @Override
    public void onBeforeDetach(Lesson entity, EntityManager entityManager) {
        /*entity.setCaptionForCalendar(*/
        calendarService.calculateCaptionForCalendarEvent(entity);
    }
}
