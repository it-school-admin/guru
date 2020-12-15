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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHOOL_CLASS_ID")
    private SchoolClass schoolClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @Column(name = "IS_FULL_CLASS_GROUP")
    private Boolean isFullClassGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_GROUP_ID")
    private GroupForLesson parentGroup;

    @Column(name = "SUB_GROUP_NAME")
    private String subGroupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @Column(name = "GROUP_EMAIL")
    @Email
    private String groupEmail;

    @Column(name = "GROUP_TEAMS_TEAM")
    private String groupTeamsTeam;

    @Column(name = "GROUP_IR_TECH_ID")
    private Integer groupIrTechId;

    @Column(name = "GROUP_IR_TECH_NAME")
    private String groupIrTechName;

    public void setGroupIrTechId(Integer groupIrTechId) {
        this.groupIrTechId = groupIrTechId;
    }

    public Integer getGroupIrTechId() {
        return groupIrTechId;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    public String getGroupTeamsTeam() {
        return groupTeamsTeam;
    }

    public void setGroupTeamsTeam(String groupTeamsTeam) {
        this.groupTeamsTeam = groupTeamsTeam;
    }

    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public Boolean getIsFullClassGroup() {
        return isFullClassGroup;
    }

    public void setIsFullClassGroup(Boolean isFullClassGroup) {
        this.isFullClassGroup = isFullClassGroup;
    }

    public String getGroupIrTechName() {
        return groupIrTechName;
    }

    public void setGroupIrTechName(String groupIrTechName) {
        this.groupIrTechName = groupIrTechName;
    }

    public GroupForLesson getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(GroupForLesson parentGroup) {
        this.parentGroup = parentGroup;
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

}