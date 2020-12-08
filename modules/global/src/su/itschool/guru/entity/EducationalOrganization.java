package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_SCHOOL")
@Entity(name = "guru_School")
@NamePattern("%s|organizationShortName")
public class EducationalOrganization extends StandardEntity {
    private static final long serialVersionUID = 179989997415554263L;

    @NotNull
    @Column(name = "ORGANIZATION_SHORT_NAME", nullable = false, unique = true)
    private String organizationShortName;

    @Column(name = "ORGANIZATION_COUNTRY")
    private String organizationCountry;

    @NotNull
    @Column(name = "ORGANIZATION_LONG_NAME", nullable = false)
    private String organizationLongName;

    @Column(name = "ORGANIZATION_DOMAIN")
    private String organizationDomain;

    public String getOrganizationCountry() {
        return organizationCountry;
    }

    public void setOrganizationCountry(String organizationCountry) {
        this.organizationCountry = organizationCountry;
    }

    public String getOrganizationDomain() {
        return organizationDomain;
    }

    public void setOrganizationDomain(String organizationDomain) {
        this.organizationDomain = organizationDomain;
    }

    public String getOrganizationLongName() {
        return organizationLongName;
    }

    public void setOrganizationLongName(String organizationLongName) {
        this.organizationLongName = organizationLongName;
    }

    public String getOrganizationShortName() {
        return organizationShortName;
    }

    public void setOrganizationShortName(String organizationShortName) {
        this.organizationShortName = organizationShortName;
    }
}