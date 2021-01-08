package su.itschool.guru.service;

import su.itschool.guru.entity.TimetableTemplate;

public interface TimetableIrTechImportService {
    String NAME = "guru_TimetableIrTechImportService";

    void clearTimeTableTemplate(TimetableTemplate timetableTemplate);
}