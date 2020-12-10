package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "GURU_TEST_ENTITY")
@Entity(name = "guru_TestEntity")
public class TestEntity extends StandardEntity {
    private static final long serialVersionUID = -6396867279875176626L;

    @Column(name = "TEST_ENTITY_NAME")
    private String testEntityName;

    public String getTestEntityName() {
        return testEntityName;
    }

    public void setTestEntityName(String testEntityName) {
        this.testEntityName = testEntityName;
    }
}