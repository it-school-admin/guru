package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Table(name = "GURU_SCHOOL_CLASS")
@Entity(name = "guru_SchoolClass")
@NamePattern("%s|className")
public class SchoolClass extends StandardEntity {
    private static final long serialVersionUID = 6151984380717443318L;

    @NotNull
    @Column(name = "CLASS_NAME", nullable = false, unique = true)
    private String className;

    @Column(name = "CLASS_LEVEL", nullable = false)
    @NotNull
    private Integer classLevel;

    @Column(name = "CLASS_EMAIL", unique = true)
    @Email
    private String classEmail;

    @JoinColumn(name = "MAIN_LESSONS_GRID_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LessonsGridType mainLessonsGridType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAIN_TEACHER_ID")
    private Teacher mainTeacher;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STUDENT_COUNT")
    @NotNull
    private Integer studentCount;

    @Column(name = "GIRLS_COUNT")
    @PositiveOrZero
    private Integer girlsCount;

    @Column(name = "BOYS_COUNT")
    @PositiveOrZero
    private Integer boysCount;

    @Column(name = "SHIFT")
    private Integer shift;

    @NotNull
    @Column(name = "IS_IN_DISTANT", nullable = false)
    private Boolean isInDistant = false;

    @Column(name = "IR_TECH_ID", nullable = false)
    @NotNull
    private Integer irTechId;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public Integer getBoysCount() {
        return boysCount;
    }

    public void setBoysCount(Integer boysCount) {
        this.boysCount = boysCount;
    }

    public Integer getGirlsCount() {
        return girlsCount;
    }

    public void setGirlsCount(Integer girlsCount) {
        this.girlsCount = girlsCount;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public Integer getIrTechId() {
        return irTechId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}