package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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