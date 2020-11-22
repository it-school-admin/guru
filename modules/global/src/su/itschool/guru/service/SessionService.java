package su.itschool.guru.service;

import su.itschool.guru.entity.Session;

import java.time.LocalDateTime;

public interface SessionService {
    String NAME = "guru_SessionService";

    Session rescheduleSession(Session session, LocalDateTime newStartTime);
}