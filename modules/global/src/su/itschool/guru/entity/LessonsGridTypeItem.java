package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "GURU_LESSONS_GRID_TYPE_ITEM")
@Entity(name = "guru_LessonsGridTypeItem")
public class LessonsGridTypeItem extends StandardEntity {
    private static final long serialVersionUID = -343143059138223608L;

    @NotNull
    @Column(name = "LESSON_NUMBER", nullable = false)
    private Integer lessonNumber;

    @NotNull
    @Column(name = "LESSON_START_TIME", nullable = false)
    private LocalDateTime lessonStartTime;

    @Column(name = "LESSON_END_TIME")
    private String lessonEndTime;

    @NotNull
    @Column(name = "GRID_TYPE", nullable = false)
    private String gridType;

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public String getLessonEndTime() {
        return lessonEndTime;
    }

    public void setLessonEndTime(String lessonEndTime) {
        this.lessonEndTime = lessonEndTime;
    }

    public LocalDateTime getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(LocalDateTime lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public String getGridType() {
        return gridType;
    }

    public void setGridType(String gridType) {
        this.gridType = gridType;
    }
}