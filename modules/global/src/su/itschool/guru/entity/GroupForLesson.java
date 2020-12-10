package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_GROUP_FOR_LESSON")
@Entity(name = "guru_GroupForLesson")
public class GroupForLesson extends StandardEntity {
    private static final long serialVersionUID = 5929795659783061502L;

    @NotNull
    @Column(name = "GROUP_NAME", nullable = false)
    private String groupName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHOOL_CLASS_ID")
    private SchoolClass schoolClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @Column(name = "TEAMS_TEAM")
    private String teamsTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_GROUP_ID")
    private GroupForLesson parentGroup;

    public GroupForLesson getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(GroupForLesson parentGroup) {
        this.parentGroup = parentGroup;
    }

    public String getTeamsTeam() {
        return teamsTeam;
    }

    public void setTeamsTeam(String teamsTeam) {
        this.teamsTeam = teamsTeam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}