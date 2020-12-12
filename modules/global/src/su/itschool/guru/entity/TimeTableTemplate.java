package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_TIME_TABLE_TEMPLATE")
@Entity(name = "guru_TimeTableTemplate")
@NamePattern("%s %s %s|scheduleName,schoolClass,educationalYear")
public class TimeTableTemplate extends StandardEntity {
    private static final long serialVersionUID = 7299830008656741285L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHOOL_CLASS_ID")
    private SchoolClass schoolClass;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATIONAL_YEAR_ID")
    private EductaionalYear educationalYear;

    @NotNull
    @Column(name = "SCHEDULE_NAME", nullable = false)
    private String scheduleName;

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public EductaionalYear getEducationalYear() {
        return educationalYear;
    }

    public void setEducationalYear(EductaionalYear educationalYear) {
        this.educationalYear = educationalYear;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}