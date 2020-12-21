package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_TEACHER")
@Entity(name = "guru_Teacher")
@NamePattern("%s %s %s|teacherFamilyName,teacherName,teacherSecondName")
public class Teacher extends StandardEntity {
    private static final long serialVersionUID = 749499474028461040L;

    @NotNull
    @Column(name = "TEACHER_NAME", nullable = false)
    private String teacherName;

    @Column(name = "TEACHER_SECOND_NAME", nullable = false)
    @NotNull
    private String teacherSecondName;

    @Column(name = "TEACHER_FAMILY_NAME", nullable = false)
    @NotNull
    private String teacherFamilyName;

    @Column(name = "TEACHER_EMAIL")
    @Email(message = "{msg://guru_Teacher.teacherEmail.validation.Email}")
    private String teacherEmail;

    @Column(name = "IR_TECH_ID", unique = true)
    private Integer irTechId;

    public Integer getIrTechId() {
        return irTechId;
    }

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherFamilyName() {
        return teacherFamilyName;
    }

    public void setTeacherFamilyName(String teacherFamilyName) {
        this.teacherFamilyName = teacherFamilyName;
    }

    public String getTeacherSecondName() {
        return teacherSecondName;
    }

    public void setTeacherSecondName(String teacherSecondName) {
        this.teacherSecondName = teacherSecondName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Transient
    @MetaProperty(related = {"teacherName", "teacherSecondName", "teacherFamilyName"})
    public String getFamilyNameWithAbbreviation(){
        return teacherFamilyName + " " + teacherName.charAt(0)+"."+teacherSecondName.charAt(0)+".";
    }

}