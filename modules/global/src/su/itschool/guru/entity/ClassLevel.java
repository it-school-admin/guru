package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_CLASS_LEVEL")
@Entity(name = "guru_ClassLevel")
@NamePattern("%s|level")
public class ClassLevel extends StandardEntity {
    private static final long serialVersionUID = 4456606036437342413L;

    @NotNull
    @Column(name = "LEVEL_", nullable = false, unique = true)
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}