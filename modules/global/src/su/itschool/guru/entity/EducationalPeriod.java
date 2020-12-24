package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_EDUCATIONAL_PERIOD")
@Entity(name = "guru_EducationalPeriod")
@NamePattern("%s|periodName")
public class EducationalPeriod extends StandardEntity {
    private static final long serialVersionUID = 4482795832891606682L;

    @NotNull
    @Column(name = "PERIOD_NAME", nullable = false)
    private String periodName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATIONAL_YEAR_ID")
    private EducationalYear educationalYear;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    @NotNull
    private LocalDate endDate;

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public EducationalYear getEducationalYear() {
        return educationalYear;
    }

    public void setEducationalYear(EducationalYear educationalYear) {
        this.educationalYear = educationalYear;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
}