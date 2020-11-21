package su.itschool.guru.web.screens.session;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Session;

@UiController("guru_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
}