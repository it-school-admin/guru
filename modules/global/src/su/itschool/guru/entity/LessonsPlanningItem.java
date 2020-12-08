package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_PLANNING_ITEM")
@Entity(name = "guru_LessonsPlanningItem")
public class LessonsPlanningItem extends StandardEntity {
    private static final long serialVersionUID = 3761661617055118840L;

    @Column(name = "SCHOOL_CLASS", nullable = false)
    @NotNull
    private String schoolClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_OF_LEARNING_ID")
    private GroupForLesson groupOfLearning;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @NotNull
    @Column(name = "HOURS_PER_WEEK", nullable = false)
    private String hoursPerWeek;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATIONAL_PERIOD_ID")
    private EducationalPeriod educationalPeriod;

    public EducationalPeriod getEducationalPeriod() {
        return educationalPeriod;
    }

    public void setEducationalPeriod(EducationalPeriod educationalPeriod) {
        this.educationalPeriod = educationalPeriod;
    }

    public String getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(String hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public GroupForLesson getGroupOfLearning() {
        return groupOfLearning;
    }

    public void setGroupOfLearning(GroupForLesson groupOfLearning) {
        this.groupOfLearning = groupOfLearning;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }
}