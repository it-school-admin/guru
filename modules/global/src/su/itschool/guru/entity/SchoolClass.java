package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "GURU_SCHOOL_CLASS")
@Entity(name = "guru_SchoolClass")
@Listeners("guru_SchoolClassEntityListener")
@NamePattern("%s|className")
public class SchoolClass extends StandardEntity {
    private static final long serialVersionUID = 6151984380717443318L;

    @Column(name = "CLASS_LEVEL", nullable = false)
    @NotNull
    private Integer classLevel;

    @NotNull
    @Column(name = "CLASS_LETTER", nullable = false)
    private Character classLetter;

    @Column(name = "CLASS_EMAIL", unique = true)
    @Email
    private String classEmail;

    @JoinColumn(name = "MAIN_LESSONS_GRID_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LessonsGridType mainLessonsGridType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAIN_TEACHER_ID")
    @NotNull
    private Teacher mainTeacher;

    @Column(name = "STUDENT_COUNT")
    @NotNull
    private Integer studentCount;

    @Column(name = "SHIFT")
    private Integer shift;

    @NotNull
    @Column(name = "IS_IN_DISTANT", nullable = false)
    private Boolean isInDistant = false;

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

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    public Integer getClassLevel() {
        return classLevel;
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
    @MetaProperty(related = {"classLetter", "classLevel"})
    public String getClassName() {
        if (classLevel != null && classLetter != null)
            return classLevel.toString() + classLetter;
        else
            return null;
    }

}