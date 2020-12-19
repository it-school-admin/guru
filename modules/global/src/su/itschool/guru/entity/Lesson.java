package su.itschool.guru.entity;

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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STUDY_GROUP_ID")
    private GroupForLesson studyGroup;

    @Column(name = "CAPTION_FOR_CALENDAR", nullable = false)
    @NotNull
    private String captionForCalendar;

    @Column(name = "START_TIME", nullable = false)
    @NotNull
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    @NotNull
    private LocalDateTime endTime;

    @JoinColumn(name = "SUBJECT_ON_THE_FLY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subjectOnTheFly;

    @JoinColumn(name = "TEACHER_ON_THE_FLY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacherOnTheFly;

    @NotNull
    @Column(name = "IS_DISTANT", nullable = false)
    private Boolean isDistant = false;

    @JoinColumn(name = "PLANNING_ITEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LessonsPlanningItem planningItem;

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

    public String getCaptionForCalendar() {
        return captionForCalendar;
    }

    public void setCaptionForCalendar(String captionForCalendar) {
        this.captionForCalendar = captionForCalendar;
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

    public GroupForLesson getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(GroupForLesson studyGroup) {
        this.studyGroup = studyGroup;
    }
}