package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "GURU_TIME_TABLE_TEMPLATE_ITEM")
@Entity(name = "guru_TimeTableTemplateItem")
public class TimeTableTemplateItem extends StandardEntity {
    private static final long serialVersionUID = 3063126557897405154L;

    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIME_TABLE_TEMPLATE_ID")
    private TimeTableTemplate timeTableTemplate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_FOR_LESSON_ID")
    private GroupForLesson groupForLesson;

    @NotNull
    @Column(name = "TIME_START", nullable = false)
    private LocalDateTime timeStart;

    @NotNull
    @Column(name = "TIME_END", nullable = false)
    private LocalDateTime timeEnd;

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public GroupForLesson getGroupForLesson() {
        return groupForLesson;
    }

    public void setGroupForLesson(GroupForLesson groupForLesson) {
        this.groupForLesson = groupForLesson;
    }

    public TimeTableTemplate getTimeTableTemplate() {
        return timeTableTemplate;
    }

    public void setTimeTableTemplate(TimeTableTemplate timeTableTemplate) {
        this.timeTableTemplate = timeTableTemplate;
    }
}