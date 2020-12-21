package su.itschool.guru.service;

import su.itschool.guru.entity.Lesson;

public interface CalendarService {
    String NAME = "guru_CalendarService";

    String calculateCaptionForCalendarEvent(Lesson entity);
}