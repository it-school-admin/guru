package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "GURU_WEEK")
@Entity(name = "guru_Week")
@NamePattern("%s %s %s|weekNumber,startDate,endDate")
public class Week extends StandardEntity {
    private static final long serialVersionUID = 2276194155440254937L;

    @Column(name = "WEEK_NUMBER", nullable = false)
    @NotNull
    private Integer weekNumber;

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

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Transient
    @MetaProperty(related = {"weekNumber", "startDate", "endDate"})
    public String getDisplayName(){
        //TODO move to static
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return weekNumber + " " + "неделя (" + startDate.format(formatter) + "-" +endDate.format(formatter)+")";

    }
}