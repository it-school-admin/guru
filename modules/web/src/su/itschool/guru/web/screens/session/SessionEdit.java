package su.itschool.guru.web.screens.session;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Session;

@UiController("guru_Session.edit")
@UiDescriptor("session-edit.xml")
@EditedEntityContainer("sessionDc")
@LoadDataBeforeShow
public class SessionEdit extends StandardEditor<Session> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Session> event) {
        event.getEntity().setDuration(1);
    }
}