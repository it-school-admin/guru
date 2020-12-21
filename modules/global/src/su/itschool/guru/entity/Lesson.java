package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "GURU_LESSON")
@Entity(name = "guru_Lesson")
@NamePattern("%s %s|startTime,planningItem")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = 5311904021082586722L;

    @JoinColumn(name = "PLANNING_ITEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LessonsPlanningItem planningItem;

    @Column(name = "START_TIME", nullable = false)
    @NotNull
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    @NotNull
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ON_THE_FLY_ID")
    private GroupForLesson groupOnTheFly;

    @JoinColumn(name = "SUBJECT_ON_THE_FLY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subjectOnTheFly;

    @JoinColumn(name = "TEACHER_ON_THE_FLY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacherOnTheFly;

    @NotNull
    @Column(name = "IS_DISTANT", nullable = false)
    private Boolean isDistant = false;

    @JoinColumn(name = "WEEK_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Week week;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Lob
    @Column(name = "TOPIC_OF_THE_LESSON")
    private String topicOfTheLesson;

    @Column(name = "TOOLS_DESCRIPTION")
    @Lob
    private String toolsDescription;

    @Lob
    @Column(name = "HOME_TASK_DESCRIPTION")
    private String homeTaskDescription;

    public GroupForLesson getGroupOnTheFly() {
        return groupOnTheFly;
    }

    public void setGroupOnTheFly(GroupForLesson groupOnTheFly) {
        this.groupOnTheFly = groupOnTheFly;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }

    public String getHomeTaskDescription() {
        return homeTaskDescription;
    }

    public void setHomeTaskDescription(String homeTaskDescription) {
        this.homeTaskDescription = homeTaskDescription;
    }

    public String getToolsDescription() {
        return toolsDescription;
    }

    public void setToolsDescription(String toolsDescription) {
        this.toolsDescription = toolsDescription;
    }

    public String getTopicOfTheLesson() {
        return topicOfTheLesson;
    }

    public void setTopicOfTheLesson(String topicOfTheLesson) {
        this.topicOfTheLesson = topicOfTheLesson;
    }

    public void setTeacherOnTheFly(Teacher teacherOnTheFly) {
        this.teacherOnTheFly = teacherOnTheFly;
    }

    public Teacher getTeacherOnTheFly() {
        return teacherOnTheFly;
    }

    public void setSubjectOnTheFly(Subject subjectOnTheFly) {
        this.subjectOnTheFly = subjectOnTheFly;
    }

    public Subject getSubjectOnTheFly() {
        return subjectOnTheFly;
    }

    public void setPlanningItem(LessonsPlanningItem planningItem) {
        this.planningItem = planningItem;
    }

    public LessonsPlanningItem getPlanningItem() {
        return planningItem;
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

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Boolean getIsDistant() {
        return isDistant;
    }

    public void setIsDistant(Boolean isDistant) {
        this.isDistant = isDistant;
    }

    @Transient
    @MetaProperty(related = {"planningItem", "isDistant"})
    public String getCaptionForCalendar() {
        return calculateCaptionForCalendarEvent();
    }

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

    private String calculateDescriptionForCalendarEvent() {
        String result = "";
        if (isDistant) {
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
        }
        return result;
    }

    private String calculateCaptionForCalendarEvent() {
        String result = "";
        if (planningItem != null) {
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
                        groupOfLearning.getSubGroupName();
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

        }

        return result;

    }

}