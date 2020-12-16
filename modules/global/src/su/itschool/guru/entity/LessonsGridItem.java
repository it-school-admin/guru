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

    @Column(name = "LESSON_START_TIME", nullable = false)
    @NotNull
    private LocalTime lessonStartTime;

    @NotNull
    @Column(name = "LESSON_END_TIME", nullable = false)
    private LocalTime lessonEndTime;

    @Column(name = "IR_TECH_SHIFT")
    private Integer irTechShift;

    @Column(name = "IR_TECH_ID")
    private Integer irTechId;

    public Integer getIrTechId() {
        return irTechId;
    }

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public void setIrTechShift(Integer irTechShift) {
        this.irTechShift = irTechShift;
    }

    public Integer getIrTechShift() {
        return irTechShift;
    }

    public void setLessonStartTime(LocalTime lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public LocalTime getLessonStartTime() {
        return lessonStartTime;
    }

    public LocalTime getLessonEndTime() {
        return lessonEndTime;
    }

    public void setLessonEndTime(LocalTime lessonEndTime) {
        this.lessonEndTime = lessonEndTime;
    }

    public LessonsGridType getGridType() {
        return gridType;
    }

    public void setGridType(LessonsGridType gridType) {
        this.gridType = gridType;
    }
}