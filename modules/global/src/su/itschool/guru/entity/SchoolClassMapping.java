package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_SCHOOL_CLASS_MAPPING")
@Entity(name = "guru_SchoolClassMapping")
public class SchoolClassMapping extends StandardEntity {
    private static final long serialVersionUID = -2272870747665091015L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHOOL_CLASS_ID")
    private SchoolClass schoolClass;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "THIRD_PARTY_SYSTEM_ID")
    private ThirdPartySystem thirdPartySystem;

    @Column(name = "OUTER_ID", nullable = false)
    @NotNull
    private Integer outerId;

    public Integer getOuterId() {
        return outerId;
    }

    public void setOuterId(Integer outerId) {
        this.outerId = outerId;
    }

    public ThirdPartySystem getThirdPartySystem() {
        return thirdPartySystem;
    }

    public void setThirdPartySystem(ThirdPartySystem thirdPartySystem) {
        this.thirdPartySystem = thirdPartySystem;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}