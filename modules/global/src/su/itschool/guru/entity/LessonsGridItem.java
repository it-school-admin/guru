package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Table(name = "GURU_LESSONS_GRID_ITEM")
@Entity(name = "guru_LessonsGridItem")
@NamePattern("%s %s|gridType,lessonNumber")
public class LessonsGridItem extends StandardEntity {
    private static final long serialVersionUID = 8221835714432453534L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GRID_TYPE_ID")
    @OnDeleteInverse(DeletePolicy.CASCADE)
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

    @Transient
    @MetaProperty(related = {"lessonStartTime", "gridType"})
    public LocalTime getLessonEndTime() {
        if(lessonStartTime != null && gridType != null)
        {
            return lessonStartTime.plusMinutes(gridType.getDefaultLessonTime());
        }
        return null;
    }
}