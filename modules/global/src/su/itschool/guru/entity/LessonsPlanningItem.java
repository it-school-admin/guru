package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_PLANNING_ITEM")
@Entity(name = "guru_LessonsPlanningItem")
@NamePattern("%s|hoursPerWeek")
public class LessonsPlanningItem extends StandardEntity {
    private static final long serialVersionUID = 3761661617055118840L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject regularSubject;

    @Column(name = "IS_INDIVIDUAL_PLAN_ITEM", nullable = false)
    @NotNull
    private Boolean isIndividualPlanItem = false;

    @JoinColumn(name = "REGULAR_GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GroupForLesson regularGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDIVIDUAL_PLAN_GROUP_ID")
    private GroupForIndividualPlanning individualPlanGroup;

    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Teacher teacher;

    @Column(name = "HOURS_PER_WEEK", nullable = false)
    @NotNull
    private Integer hoursPerWeek;

    @Column(name = "IR_TECH_ID", unique = true)
    private Integer irTechID;

    @Transient
    @MetaProperty(related = {"regularSubject", "isIndividualPlanItem", "individualPlanGroup"}, mandatory = true)
    public Subject getSubject() {
        if(!isIndividualPlanItem)
        {
            if(regularSubject != null)
            {
                return regularSubject;

            }
        }
        else
        {
            if(individualPlanGroup != null)
            {
                return individualPlanGroup.getSubject();
            }
        }

        return null;
    }

    public GroupForIndividualPlanning getIndividualPlanGroup() {
        return individualPlanGroup;
    }

    public void setIndividualPlanGroup(GroupForIndividualPlanning individualPlanGroup) {
        this.individualPlanGroup = individualPlanGroup;
    }

    public Boolean getIsIndividualPlanItem() {
        return isIndividualPlanItem;
    }

    public void setIsIndividualPlanItem(Boolean isIndividualPlanItem) {
        this.isIndividualPlanItem = isIndividualPlanItem;
    }

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

    public Subject getRegularSubject() {
        return regularSubject;
    }

    public void setRegularSubject(Subject regularSubject) {
        this.regularSubject = regularSubject;
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