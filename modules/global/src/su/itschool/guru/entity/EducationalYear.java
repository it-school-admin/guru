package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_EDUCATIONAL_YEAR")
@Entity(name = "guru_EducationalYear")
@NamePattern("%s|name")
public class EducationalYear extends StandardEntity {
    private static final long serialVersionUID = -613892533999516565L;

    @Column(name = "NAME", nullable = false, unique = true)
    @NotNull
    private String name;

    @Column(name = "START_DATE", nullable = false)
    @NotNull
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    @NotNull
    private LocalDate endDate;

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}