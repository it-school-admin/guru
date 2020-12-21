package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_WEEK_DAY")
@Entity(name = "guru_WeekDay")
@NamePattern("%s|dayName")
public class WeekDay extends StandardEntity {
    private static final long serialVersionUID = -3847667244254059918L;

    @Column(name = "DAY_NUMBER", nullable = false, unique = true)
    @NotNull
    private Integer dayNumber;

    @NotNull
    @Column(name = "DAY_NAME", nullable = false, unique = true)
    private String dayName;

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

}