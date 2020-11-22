package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.Session;

import javax.inject.Inject;
import java.time.LocalDateTime;

@Service(SessionService.NAME)
public class SessionServiceBean implements SessionService {

    @Inject
    private DataManager dataManager;

    @Override
    public Session rescheduleSession(Session session, LocalDateTime newStartTime) {
        session.setStartTime(newStartTime);
        return dataManager.commit(session);
    }
}