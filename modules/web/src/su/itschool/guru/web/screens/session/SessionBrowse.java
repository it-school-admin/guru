package su.itschool.guru.web.screens.session;

import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Session;
import su.itschool.guru.service.SessionService;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("guru_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private EditorScreenFacet<Session, SessionEdit> sessionEditorScreen;
    @Inject
    private SessionService sessionService;
    @Inject
    private CollectionContainer<Session> sessionsDc;

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        sessionEditorScreen.setEntityProvider(()-> (Session) event.getEntity());
        sessionEditorScreen.show();
    }

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent<LocalDateTime> event) {
        Session session = sessionService.rescheduleSession((Session) event.getEntity(), event.getNewStart());
        sessionsDc.replaceItem(session);
    }
}