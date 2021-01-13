package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@PublishEntityChangedEvents
@Table(name = "GURU_LESSONS_GRID")
@Entity(name = "guru_LessonsGrid")
@NamePattern("%s|lessonsGridTypeName")
//todo rename to LessonsGrid
public class LessonsGridType extends StandardEntity {
    private static final long serialVersionUID = 2345773260521548188L;

    @NotNull
    @Column(name = "LESSONS_GRID_TYPE_NAME", nullable = false)
    private String lessonsGridTypeName;

    @NotNull
    @Column(name = "DEFAULT_LESSON_TIME", nullable = false)
    private Integer defaultLessonTime;

    @Column(name = "DEFAULT_PAUSE_DURATION")
    private Integer defaultPauseDuration;

    @Column(name = "STANDARD_AMOUNT_OF_LESSONS")
    private Integer standardAmountOfLessons;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    public Integer getStandardAmountOfLessons() {
        return standardAmountOfLessons;
    }

    public void setStandardAmountOfLessons(Integer standardAmountOfLessons) {
        this.standardAmountOfLessons = standardAmountOfLessons;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Integer getDefaultPauseDuration() {
        return defaultPauseDuration;
    }

    public void setDefaultPauseDuration(Integer defaultPauseDuration) {
        this.defaultPauseDuration = defaultPauseDuration;
    }

    public Integer getDefaultLessonTime() {
        return defaultLessonTime;
    }

    public void setDefaultLessonTime(Integer defaultLessonTime) {
        this.defaultLessonTime = defaultLessonTime;
    }

    public String getLessonsGridTypeName() {
        return lessonsGridTypeName;
    }

    public void setLessonsGridTypeName(String lessonsGridTypeName) {
        this.lessonsGridTypeName = lessonsGridTypeName;
    }

}