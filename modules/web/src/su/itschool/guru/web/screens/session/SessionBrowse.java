package su.itschool.guru.web.screens.session;

import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Session;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("guru_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private EditorScreenFacet<Session, SessionEdit> sessionEditorScreen;

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        sessionEditorScreen.setEntityProvider(()-> (Session) event.getEntity());
        sessionEditorScreen.show();
    }
}