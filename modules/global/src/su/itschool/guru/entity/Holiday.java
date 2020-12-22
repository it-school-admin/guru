package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_HOLIDAY")
@Entity(name = "guru_Holiday")
public class Holiday extends StandardEntity {
    private static final long serialVersionUID = -6981988635583498264L;

    @NotNull
    @Column(name = "HOLIDAY_NAME", nullable = false)
    private String holidayName;

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}