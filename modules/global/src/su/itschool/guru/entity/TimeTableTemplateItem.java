package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import su.itschool.guru.entity.enums.WeekDay;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_TIME_TABLE_TEMPLATE_ITEM")
@Entity(name = "guru_TimeTableTemplateItem")
public class TimeTableTemplateItem extends StandardEntity {
    private static final long serialVersionUID = 3063126557897405154L;

    @NotNull
    @Column(name = "NUMBER_OF_LESSON", nullable = false)
    private Integer numberOfLesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @NotNull
    @Column(name = "WEEK_DAY", nullable = false)
    private Integer weekDay;

    @JoinColumn(name = "PLANNING_ITEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(DeletePolicy.CASCADE)
    private LessonsPlanningItem planningItem;

    public WeekDay getWeekDay() {
        return weekDay == null ? null : WeekDay.fromId(weekDay);
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay == null ? null : weekDay.getId();
    }

    public Integer getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(Integer numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
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

}