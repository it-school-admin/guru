package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "GURU_SUBJECT")
@Entity(name = "guru_Subject")
@NamePattern("%s|subjectName")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = 8966885222940773321L;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "IR_TECH_ID", unique = true)
    private Integer irTechId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_SUBJECT_ID")
    private Subject parentSubject;

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public Integer getIrTechId() {
        return irTechId;
    }

    public Subject getParentSubject() {
        return parentSubject;
    }

    public void setParentSubject(Subject parentSubject) {
        this.parentSubject = parentSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}