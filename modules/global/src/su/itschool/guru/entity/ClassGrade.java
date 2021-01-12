package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import su.itschool.guru.entity.enums.PlanningType;

import javax.persistence.*;
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

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @OnDeleteInverse(DeletePolicy.DENY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LEVEL_ID")
    private StudyLevel level;

    public StudyLevel getLevel() {
        return level;
    }

    public void setLevel(StudyLevel level) {
        this.level = level;
    }

    public PlanningType getPlanningType() {
        return planningType == null ? null : PlanningType.fromId(planningType);
    }

    public void setPlanningType(PlanningType planningType) {
        this.planningType = planningType == null ? null : planningType.getId();
    }

    public Integer getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Integer gradeNumber) {
        this.gradeNumber = gradeNumber;
    }
}