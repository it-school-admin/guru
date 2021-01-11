package su.itschool.guru.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PlanningTypes implements EnumClass<Integer> {

    CLASS_PLANNING(10),
    INDIVIDUAL_PLANNING(20);

    private Integer id;

    PlanningTypes(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static PlanningTypes fromId(Integer id) {
        for (PlanningTypes at : PlanningTypes.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}