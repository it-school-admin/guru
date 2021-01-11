package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_STUDY_PROFILE")
@Entity(name = "guru_StudyProfile")
@NamePattern("%s|profileName")
public class StudyProfile extends StandardEntity {
    private static final long serialVersionUID = -1477799750278897264L;

    @NotNull
    @Column(name = "PROFILE_NAME", nullable = false, unique = true)
    private String profileName;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}