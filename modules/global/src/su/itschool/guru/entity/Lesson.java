package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Table(name = "GURU_LESSON")
@Entity(name = "guru_Lesson")
@NamePattern("%s|startTime")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = 5311904021082586722L;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAN_ITEM_ID")
    private LessonsPlanningItem planItem;

    @Column(name = "START_TIME", nullable = false)
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    @Positive(message = "{msg://guru_Lesson.duration.validation.Positive}")
    private Integer duration;

    @NotNull
    @Column(name = "IS_DISTANT", nullable = false)
    private Boolean isDistant = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    public LessonsPlanningItem getPlanItem() {
        return planItem;
    }

    public void setPlanItem(LessonsPlanningItem planItem) {
        this.planItem = planItem;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Boolean getIsDistant() {
        return isDistant;
    }

    public void setIsDistant(Boolean isDistant) {
        this.isDistant = isDistant;
    }

/*    @Transient
    @MetaProperty(related = {"planningItem", "isDistant"})
    public String getCaptionForCalendar() {
        return calculateCaptionForCalendarEvent();
    }*/

    @Transient
    @MetaProperty(related = {"isDistant", "room"})
    public String getDescriptionForCalendar() {
        return calculateDescriptionForCalendarEvent();
    }

    @Transient
    @MetaProperty(related = {"isDistant"})
    public String getStyleForCalendar() {
        if (isDistant) {
            return "event-green";

        } else {
            return "event-blue";
        }
    }

    @Transient
    @MetaProperty(related = {"startTime", "duration"})
    public LocalDateTime getEndTime() {
        return startTime.plusMinutes(duration);
    }

    private String calculateDescriptionForCalendarEvent() {
        String result = "";
      /*  if (isDistant) {
            result = "Дистанционный";
        } else {
            result = "Очный";
            if(room != null)
            {
                result = result + ", " + room.getRoomName();
            }
        }
        if (planningItem != null) {
            result = result + " " + planningItem.getGroupOfLearning().getTeacher().getFamilyNameWithAbbreviation();
        }*/
        return result;
    }

    private String calculateCaptionForCalendarEvent() {
        String result = "";
       /* if (planningItem != null) {
            GroupForLesson groupOfLearning = planningItem.getGroupOfLearning();
            if (groupOfLearning.getIsFullClassGroup()) {
                result = groupOfLearning.getSchoolClass().getClassName() +
                        " " +
                        groupOfLearning.getSubject().getSubjectName();

            } else {
                result = groupOfLearning.getSchoolClass().getClassName() +
                        " " +
                        groupOfLearning.getSubject().getSubjectName() +
                        " " +
                        groupOfLearning.getOwnName();
            }

            result = result + " " + planningItem.getGroupOfLearning().getTeacher().getFamilyNameWithAbbreviation();

            if (isDistant) {
                result = result + " дистанционный";
            } else {
                result = result + " очный";
                if (room != null) {
                    result = result + ", "+room.getRoomName();
                }
            }

        }*/

        return result;

    }

}