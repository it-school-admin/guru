package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_GROUP_ID")
    @OnDelete(DeletePolicy.DENY)
    private GroupForLesson parentGroup;

    @Column(name = "OWN_NAME")
    private String ownName;

    @Column(name = "GROUP_EMAIL")
    @Email
    private String groupEmail;

    @Column(name = "COUNT_STUDENT")
    private Integer countStudent;

    @Column(name = "GROUP_IR_TECH_ID")
    private Integer irTechId;

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

    public void setIrTechId(Integer irTechId) {
        this.irTechId = irTechId;
    }

    public Integer getIrTechId() {
        return irTechId;
    }

    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public GroupForLesson getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(GroupForLesson parentGroup) {
        this.parentGroup = parentGroup;
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
    @MetaProperty(related = {"schoolClass", "ownName"})
    public String getGroupName()
    {
        if(parentGroup == null)
        {
            if(schoolClass != null)
            {
                return schoolClass.getClassName();
            }
        }
        else
        {
            if(schoolClass != null && ownName != null)
            {
                return schoolClass.getClassName() + "/" +  ownName;
            }
        }
        return "";
    }
}