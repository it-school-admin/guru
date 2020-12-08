package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "GURU_SUBJECT")
@Entity(name = "guru_Subject")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = 8966885222940773321L;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}