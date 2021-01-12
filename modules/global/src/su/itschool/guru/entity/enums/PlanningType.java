package su.itschool.guru.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PlanningType implements EnumClass<Integer> {

    CLASS_PLANNING(10),
    INDIVIDUAL_PLANNING(20);

    private Integer id;

    PlanningType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static PlanningType fromId(Integer id) {
        for (PlanningType at : PlanningType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}