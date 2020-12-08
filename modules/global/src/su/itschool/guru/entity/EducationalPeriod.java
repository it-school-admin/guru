package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_EDUCATIONAL_PERIODS")
@Entity(name = "guru_EducationalPeriods")
public class EducationalPeriod extends StandardEntity {
    private static final long serialVersionUID = 3976693645394047106L;

    @NotNull
    @Column(name = "PERIOD_NAME", nullable = false)
    private String periodName;

    @Column(name = "EDUCATIONAL_YEAR")
    private String educationalYear;

    public String getEducationalYear() {
        return educationalYear;
    }

    public void setEducationalYear(String educationalYear) {
        this.educationalYear = educationalYear;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
}