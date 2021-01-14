package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "GURU_SCHOOL_CLASS")
@Entity(name = "guru_SchoolClass")
@NamePattern("%s|className")
public class SchoolClass extends StandardEntity {
    private static final long serialVersionUID = 6151984380717443318L;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @OnDeleteInverse(DeletePolicy.DENY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GRADE_ID")
    @NotNull
    private ClassGrade grade;

    @NotNull
    @Column(name = "CLASS_LETTER", nullable = false)
    private Character classLetter;

    @Column(name = "CLASS_EMAIL", unique = true)
    @Email
    private String classEmail;

    @JoinColumn(name = "MAIN_LESSONS_GRID_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LessonsGridType mainLessonsGridType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAIN_TEACHER_ID")
    private Teacher mainTeacher;

    @Column(name = "STUDENT_COUNT")
    @NotNull
    private Integer studentCount;

    @Column(name = "SHIFT")
    private Integer shift;

    @NotNull
    @Column(name = "IS_IN_DISTANT", nullable = false)
    private Boolean isInDistant = false;

    @Column(name = "IR_TECH_ID")
    private Integer irTechId;

    @JoinTable(name = "GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK",
            joinColumns = @JoinColumn(name = "SCHOOL_CLASS_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_FOR_INDIVIDUAL_PLANNING_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    private List<GroupForIndividualPlanning> groupForIndividualPlannings;

    public ClassGrade getGrade() {
        return grade;
    }

    public void setGrade(ClassGrade grade) {
        this.grade = grade;
    }

    public List<GroupForIndividualPlanning> getGroupForIndividualPlannings() {
        return groupForIndividualPlannings;
    }

    public void setGroupForIndividualPlannings(List<GroupForIndividualPlanning> groupForIndividualPlannings) {
        this.groupForIndividualPlannings = groupForIndividualPlannings;
    }

    public Integer getIrTechId() {
        return irTechId;
    }

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public Character getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(Character classLetter) {
        this.classLetter = classLetter;
    }

    public Boolean getIsInDistant() {
        return isInDistant;
    }

    public void setIsInDistant(Boolean isInDistant) {
        this.isInDistant = isInDistant;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public void setMainLessonsGridType(LessonsGridType mainLessonsGridType) {
        this.mainLessonsGridType = mainLessonsGridType;
    }

    public LessonsGridType getMainLessonsGridType() {
        return mainLessonsGridType;
    }

    public String getClassEmail() {
        return classEmail;
    }

    public void setClassEmail(String classEmail) {
        this.classEmail = classEmail;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    @Transient
    @MetaProperty(related = {"classLetter", "grade"})
    public String getClassName() {
        if (classLetter != null && grade != null)
            return grade.getGradeNumber().toString() + classLetter;
        else
            return null;
    }

}