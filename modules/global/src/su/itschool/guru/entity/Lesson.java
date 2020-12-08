package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSON")
@Entity(name = "guru_Lesson")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = 5311904021082586722L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STUDY_GROUP_ID")
    private GroupForLesson studyGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private LessonsPlanningItem subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @NotNull
    @Column(name = "START_TIME", nullable = false)
    private String startTime;

    @NotNull
    @Column(name = "END_TIME", nullable = false)
    private String endTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LessonsPlanningItem getSubject() {
        return subject;
    }

    public void setSubject(LessonsPlanningItem subject) {
        this.subject = subject;
    }

    public GroupForLesson getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(GroupForLesson studyGroup) {
        this.studyGroup = studyGroup;
    }
}