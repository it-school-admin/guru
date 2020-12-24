package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_ACADEMIC_HOLIDAYS")
@Entity(name = "guru_AcademicHolidays")
@NamePattern("%s|holidaysName")
public class AcademicHolidays extends StandardEntity {
    private static final long serialVersionUID = 7795140689208360982L;

    @NotNull
    @Column(name = "HOLIDAYS_NAME", nullable = false)
    private String holidaysName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERIOD_ID")
    private EducationalPeriod period;

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

    public EducationalPeriod getPeriod() {
        return period;
    }

    public void setPeriod(EducationalPeriod period) {
        this.period = period;
    }

    public String getHolidaysName() {
        return holidaysName;
    }

    public void setHolidaysName(String holidaysName) {
        this.holidaysName = holidaysName;
    }
}