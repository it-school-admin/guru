package su.itschool.guru.service;

import su.itschool.guru.entity.EducationalYear;

public interface FillingWeeksService {
    String NAME = "guru_FillingWeeksService";
    void fillWeeks(EducationalYear educationalYear);
}