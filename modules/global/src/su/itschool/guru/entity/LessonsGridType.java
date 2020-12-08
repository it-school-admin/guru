package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_LESSONS_GRID")
@Entity(name = "guru_LessonsGrid")
public class LessonsGridType extends StandardEntity {
    private static final long serialVersionUID = 2345773260521548188L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZATION_ID")
    private EducationalOrganization organization;

    public EducationalOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(EducationalOrganization organization) {
        this.organization = organization;
    }
}