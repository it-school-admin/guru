package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_EDUCATIONAL_PERIODS")
@Entity(name = "guru_EducationalPeriods")
public class EducationalPeriod extends StandardEntity {
    private static final long serialVersionUID = 3976693645394047106L;

    @NotNull
    @Column(name = "PERIOD_NAME", nullable = false)
    private String periodName;

    @Column(name = "EDUCATIONAL_YEAR", nullable = false)
    @NotNull
    private String educationalYear;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

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