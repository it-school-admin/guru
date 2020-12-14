package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_PLANNING_ITEM")
@Entity(name = "guru_LessonsPlanningItem")
public class LessonsPlanningItem extends StandardEntity {
    private static final long serialVersionUID = 3761661617055118840L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_OF_LEARNING_ID")
    private GroupForLesson groupOfLearning;

    @NotNull
    @Column(name = "HOURS_PER_WEEK", nullable = false)
    private String hoursPerWeek;

    @Column(name = "IR_TECH_ID", unique = true)
    private Integer irTechID;

    public Integer getIrTechID() {
        return irTechID;
    }

    public void setIrTechID(Integer irTechID) {
        this.irTechID = irTechID;
    }

    public String getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(String hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public GroupForLesson getGroupOfLearning() {
        return groupOfLearning;
    }

    public void setGroupOfLearning(GroupForLesson groupOfLearning) {
        this.groupOfLearning = groupOfLearning;
    }

}