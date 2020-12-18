package su.itschool.guru.service;

import su.itschool.guru.entity.Week;

public interface CopyTimeTableForWeekFromTemplateService {
    String NAME = "guru_CopyTimeTableForWeekFromTemplateService";

    void copyTimeTableForWeekFromTemplate(Week week, Boolean isDistant);
}