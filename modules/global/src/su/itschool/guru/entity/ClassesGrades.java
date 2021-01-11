package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_CLASSES_GRADES")
@Entity(name = "guru_ClassesGrades")
public class ClassesGrades extends StandardEntity {
    private static final long serialVersionUID = 773132879402204321L;

    @NotNull
    @Column(name = "GRADE_NUMBER", nullable = false, unique = true)
    private Integer gradeNumber;

    public Integer getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Integer gradeNumber) {
        this.gradeNumber = gradeNumber;
    }
}