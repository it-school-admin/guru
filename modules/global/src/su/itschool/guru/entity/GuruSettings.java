package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Table(name = "GURU_GURU_SETTINGS")
@Entity(name = "guru_GuruSettings")
@NamePattern("%s|settingKey")
public class GuruSettings extends StandardEntity {
    private static final long serialVersionUID = 1425322105711617861L;

    @NotNull
    @Column(name = "SETTING_KEY", nullable = false)
    private String settingKey;

    @Column(name = "STRING_VALUE")
    private String stringValue;

    @Column(name = "INTEGER_VALUE")
    private Integer integerValue;

    @Column(name = "DATE_VALUE")
    private LocalDate dateValue;

    @Column(name = "TIME_VALUE")
    private LocalTime timeValue;

    @Column(name = "DATE_TIME_VALUE")
    private LocalDateTime dateTimeValue;

    @Lob
    @Column(name = "TEXT_VALUE")
    private String textValue;

    @Column(name = "OBJECT_VALUE")
    private UUID objectValue;

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public UUID getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(UUID objectValue) {
        this.objectValue = objectValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public LocalDateTime getDateTimeValue() {
        return dateTimeValue;
    }

    public void setDateTimeValue(LocalDateTime dateTimeValue) {
        this.dateTimeValue = dateTimeValue;
    }

    public LocalTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalTime timeValue) {
        this.timeValue = timeValue;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }
}