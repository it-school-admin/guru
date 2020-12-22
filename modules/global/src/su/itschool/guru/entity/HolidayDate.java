package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_HOLIDAY_DATE")
@Entity(name = "guru_HolidayDate")
public class HolidayDate extends StandardEntity {
    private static final long serialVersionUID = -9056075839777280548L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOLIDAY_ID")
    private Holiday holiday;

    @NotNull
    @Column(name = "HOLIDAY_DATE", nullable = false)
    private LocalDate holidayDate;

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}