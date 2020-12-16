package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Table(name = "GURU_TIME_TABLE_TEMPLATE_ITEM")
@Entity(name = "guru_TimeTableTemplateItem")
public class TimeTableTemplateItem extends StandardEntity {
    private static final long serialVersionUID = 3063126557897405154L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_FOR_LESSON_ID")
    private GroupForLesson groupForLesson;

    @Column(name = "FREE_SUBJECT")
    private String freeSubject;

    @Column(name = "DAY_OF_WEEK", nullable = false)
    @NotNull
    private String dayOfWeek;

    @Column(name = "TIME_START", nullable = false)
    @NotNull
    private LocalTime timeStart;

    @Column(name = "TIME_END", nullable = false)
    @NotNull
    private LocalTime timeEnd;

    @Column(name = "PLANNING_ITEM")
    private String planningItem;

    public String getFreeSubject() {
        return freeSubject;
    }

    public void setFreeSubject(String freeSubject) {
        this.freeSubject = freeSubject;
    }

    public String getPlanningItem() {
        return planningItem;
    }

    public void setPlanningItem(String planningItem) {
        this.planningItem = planningItem;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public GroupForLesson getGroupForLesson() {
        return groupForLesson;
    }

    public void setGroupForLesson(GroupForLesson groupForLesson) {
        this.groupForLesson = groupForLesson;
    }

}