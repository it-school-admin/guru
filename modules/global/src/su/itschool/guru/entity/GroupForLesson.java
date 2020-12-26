package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_GROUP_FOR_LESSON")
@Entity(name = "guru_GroupForLesson")
@NamePattern("%s|groupName")
public class GroupForLesson extends StandardEntity {
    private static final long serialVersionUID = 5929795659783061502L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHOOL_CLASS_ID")
    private SchoolClass schoolClass;

    @Column(name = "IS_FULL_CLASS_GROUP")
    private Boolean isFullClassGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_GROUP_ID")
    private GroupForLesson parentGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @Column(name = "OWN_NAME")
    private String ownName;

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

    @Column(name = "COUNT_STUDENT")
    private Integer countStudent;

    @Column(name = "GROUP_IR_TECH_NAME")
    private String groupIrTechName;

    public Integer getCountStudent() {
        return countStudent;
    }

    public void setCountStudent(Integer countStudent) {
        this.countStudent = countStudent;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public void setGroupIrTechId(Integer groupIrTechId) {
        this.groupIrTechId = groupIrTechId;
    }

    public Integer getGroupIrTechId() {
        return groupIrTechId;
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

    @Transient
    @MetaProperty(related = {"parentGroup"})
    public Boolean getIsRootClassGroup()
    {
        return parentGroup==null;
    }

    @Transient
    @MetaProperty(related = {"subject"})
    public Boolean getIsSubjectGroup()
    {
        return subject!=null;
    }

    @Transient
    @MetaProperty(related = {"schoolClass", "subject", "ownName"})
    public String getGroupName()
    {
        if(getIsRootClassGroup())
        {
            return schoolClass.getClassName();
        }
        if(getIsSubjectGroup())
        {
            return schoolClass.getClassName() + "/" + subject.getSubjectName();
        }
        if(!isFullClassGroup && getIsSubjectGroup())
        {
            return schoolClass.getClassName() + "/" + subject.getSubjectName() + "/" + ownName;
        }
        //TODO give exception name
        throw new RuntimeException();
    }
}