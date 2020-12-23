package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_TIME_TABLE_TEMPLATE_ITEM")
@Entity(name = "guru_TimeTableTemplateItem")
public class TimeTableTemplateItem extends StandardEntity {
    private static final long serialVersionUID = 3063126557897405154L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_FOR_LESSON_ID")
    private GroupForLesson groupForLesson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DAY_OF_WEEK_ID")
    private WeekDay dayOfWeek;

    @NotNull
    @Column(name = "NUMBER_OF_LESSON", nullable = false)
    private Integer numberOfLesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @JoinColumn(name = "PLANNING_ITEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(DeletePolicy.CASCADE)
    private LessonsPlanningItem planningItem;

    public Integer getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(Integer numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public WeekDay getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(WeekDay dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setPlanningItem(LessonsPlanningItem planningItem) {
        this.planningItem = planningItem;
    }

    public LessonsPlanningItem getPlanningItem() {
        return planningItem;
    }

    public GroupForLesson getGroupForLesson() {
        return groupForLesson;
    }

    public void setGroupForLesson(GroupForLesson groupForLesson) {
        this.groupForLesson = groupForLesson;
    }

}