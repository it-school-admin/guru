package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_SCHOOL_CLASS")
@Entity(name = "guru_SchoolClass")
@NamePattern("%s %s|classLevel,classLetter")
public class SchoolClass extends StandardEntity {
    private static final long serialVersionUID = 6151984380717443318L;

    @JoinColumn(name = "CLASS_LEVEL_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private ClassLevel classLevel;

    @NotNull
    @Column(name = "IR_TECH_ID", nullable = false)
    private String irTechId;

    @JoinColumn(name = "CLASS_LETTER_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private ClassLetter classLetter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATIONAL_YEAR_ID")
    private EductaionalYear educationalYear;

    @NotNull
    @Column(name = "CLASS_EMAIL", nullable = false, unique = true)
    @Email
    private String classEmail;

    @JoinColumn(name = "MAIN_LESSONS_GRID_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private LessonsGridType mainLessonsGridType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZATION_ID")
    private EducationalOrganization organization;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAIN_TEACHER_ID")
    private Teacher mainTeacher;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getIrTechId() {
        return irTechId;
    }

    public void setIrTechId(String irTechId) {
        this.irTechId = irTechId;
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

    public EductaionalYear getEducationalYear() {
        return educationalYear;
    }

    public void setEducationalYear(EductaionalYear educationalYear) {
        this.educationalYear = educationalYear;
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

    public void setClassLevel(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public void setClassLetter(ClassLetter classLetter) {
        this.classLetter = classLetter;
    }

    public ClassLetter getClassLetter() {
        return classLetter;
    }

    public EducationalOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(EducationalOrganization organization) {
        this.organization = organization;
    }

}