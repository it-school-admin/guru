package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Table(name = "GURU_LESSONS_GRID_ITEM")
@Entity(name = "guru_LessonsGridItem")
public class LessonsGridItem extends StandardEntity {
    private static final long serialVersionUID = 8221835714432453534L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GRID_TYPE_ID")
    private LessonsGridType gridType;

    @NotNull
    @Column(name = "LESSON_NUMBER", nullable = false)
    private Integer lessonNumber;

    @Column(name = "LESSON_START_TIME", nullable = false)
    @NotNull
    private LocalTime lessonStartTime;

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public void setLessonStartTime(LocalTime lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public LocalTime getLessonStartTime() {
        return lessonStartTime;
    }

    public LessonsGridType getGridType() {
        return gridType;
    }

    public void setGridType(LessonsGridType gridType) {
        this.gridType = gridType;
    }
}