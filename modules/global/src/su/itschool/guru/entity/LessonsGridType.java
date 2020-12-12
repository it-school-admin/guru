package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_GRID")
@Entity(name = "guru_LessonsGrid")
@NamePattern("%s|lessonsGridTypeName")
public class LessonsGridType extends StandardEntity {
    private static final long serialVersionUID = 2345773260521548188L;

    @NotNull
    @Column(name = "LESSONS_GRID_TYPE_NAME", nullable = false)
    private String lessonsGridTypeName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZATION_ID")
    private EducationalOrganization organization;

    public String getLessonsGridTypeName() {
        return lessonsGridTypeName;
    }

    public void setLessonsGridTypeName(String lessonsGridTypeName) {
        this.lessonsGridTypeName = lessonsGridTypeName;
    }

    public EducationalOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(EducationalOrganization organization) {
        this.organization = organization;
    }
}