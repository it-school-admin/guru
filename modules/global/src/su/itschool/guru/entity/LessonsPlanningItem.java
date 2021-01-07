package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_PLANNING_ITEM")
@Entity(name = "guru_LessonsPlanningItem")
@NamePattern("%s|hoursPerWeek")
public class LessonsPlanningItem extends StandardEntity {
    private static final long serialVersionUID = 3761661617055118840L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    @NotNull
    private Subject subject;

    @JoinColumn(name = "REGULAR_GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GroupForLesson regularGroup;

    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Teacher teacher;

    @Column(name = "HOURS_PER_WEEK", nullable = false)
    @NotNull
    private Integer hoursPerWeek;

    @Column(name = "IR_TECH_ID", unique = true)
    private Integer irTechID;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setRegularGroup(GroupForLesson regularGroup) {
        this.regularGroup = regularGroup;
    }

    public GroupForLesson getRegularGroup() {
        return regularGroup;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public Integer getIrTechID() {
        return irTechID;
    }

    public void setIrTechID(Integer irTechID) {
        this.irTechID = irTechID;
    }

}