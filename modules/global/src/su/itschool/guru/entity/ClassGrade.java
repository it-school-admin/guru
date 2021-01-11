package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import su.itschool.guru.entity.enums.PlanningTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_CLASS_GRADE")
@Entity(name = "guru_ClassGrade")
@NamePattern("%s|gradeNumber")
public class ClassGrade extends StandardEntity {
    private static final long serialVersionUID = 8102553309090450084L;

    @NotNull
    @Column(name = "GRADE_NUMBER", nullable = false, unique = true)
    private Integer gradeNumber;

    @NotNull
    @Column(name = "PLANNING_TYPE", nullable = false)
    private Integer planningType;

    public PlanningTypes getPlanningType() {
        return planningType == null ? null : PlanningTypes.fromId(planningType);
    }

    public void setPlanningType(PlanningTypes planningType) {
        this.planningType = planningType == null ? null : planningType.getId();
    }

    public Integer getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Integer gradeNumber) {
        this.gradeNumber = gradeNumber;
    }
}