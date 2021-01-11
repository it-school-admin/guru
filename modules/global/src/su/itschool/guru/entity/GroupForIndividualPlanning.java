package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Table(name = "GURU_GROUP_FOR_INDIVIDUAL_PLANNING")
@Entity(name = "guru_GroupForIndividualPlanning")
@NamePattern("%s|fullName")
public class GroupForIndividualPlanning extends StandardEntity {
    private static final long serialVersionUID = -8155404451291370219L;

    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @JoinTable(name = "GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK",
            joinColumns = @JoinColumn(name = "GROUP_FOR_INDIVIDUAL_PLANNING_ID"),
            inverseJoinColumns = @JoinColumn(name = "SCHOOL_CLASS_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @ManyToMany
    private Set<SchoolClass> linkedClasses;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @OnDeleteInverse(DeletePolicy.DENY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDY_PROFILE_ID")
    private StudyProfile studyProfile;

    @Column(name = "STUDENTS_COUNT")
    private Integer studentsCount;

    @Column(name = "PLAN_ITEM_IR_TECH_ID")
    private Integer planItemIrTechId;

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    @Transient
    @MetaProperty(related = {"name", "subject"})
    public String getFullName() {
        return subject.getSubjectName() + "/" + name;
    }

    public Integer getPlanItemIrTechId() {
        return planItemIrTechId;
    }

    public void setPlanItemIrTechId(Integer planItemIrTechId) {
        this.planItemIrTechId = planItemIrTechId;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<SchoolClass> getLinkedClasses() {
        return linkedClasses;
    }

    public void setLinkedClasses(Set<SchoolClass> linkedClasses) {
        this.linkedClasses = linkedClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}