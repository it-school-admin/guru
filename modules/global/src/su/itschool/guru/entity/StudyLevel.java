package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_STUDY_LEVEL")
@Entity(name = "guru_StudyLevel")
@NamePattern("%s|levelName")
public class StudyLevel extends StandardEntity {
    private static final long serialVersionUID = -2743906950110199931L;

    @NotNull
    @Column(name = "LEVEL_NAME", nullable = false, unique = true)
    private String levelName;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}