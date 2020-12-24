package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import su.itschool.guru.entity.enums.HolidayDateChangeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "GURU_HOLIDAY_DATE")
@Entity(name = "guru_HolidayDate")
@NamePattern("%s %s|holiday,holidayDate")
public class HolidayDate extends StandardEntity {
    private static final long serialVersionUID = -9056075839777280548L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOLIDAY_ID")
    private Holiday holiday;

    @NotNull
    @Column(name = "HOLIDAY_DATE", nullable = false)
    private LocalDate holidayDate;

    @NotNull
    @Column(name = "DATE_CHANGE_TYPE", nullable = false)
    private Integer dateChangeType;

    public HolidayDateChangeType getDateChangeType() {
        return dateChangeType == null ? null : HolidayDateChangeType.fromId(dateChangeType);
    }

    public void setDateChangeType(HolidayDateChangeType dateChangeType) {
        this.dateChangeType = dateChangeType == null ? null : dateChangeType.getId();
    }

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