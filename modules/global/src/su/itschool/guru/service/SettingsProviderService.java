package su.itschool.guru.service;

public interface SettingsProviderService {
    String NAME = "guru_SettingsProviderService";
    public static final String FULL_TIME_LESSON_DEFAULT_DURATION = "fullTimeLessonDefaultDuration";
    public static final String DISTANT_LESSON_DEFAULT_DURATION = "distantLessonDefaultDuration";


    Integer getIntegerParameter(String parameterName);
}