package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_THIRD_PARTY_SYSTEM")
@Entity(name = "guru_ThirdPartySystem")
@NamePattern("%s|systemName")
public class ThirdPartySystem extends StandardEntity {
    private static final long serialVersionUID = 2165638450536260339L;

    @NotNull
    @Column(name = "SYSTEM_NAME", nullable = false)
    private String systemName;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}