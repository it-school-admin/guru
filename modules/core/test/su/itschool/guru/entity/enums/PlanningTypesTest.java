package su.itschool.guru.entity.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningTypesTest {

    @Test
    void testValues(){
        assertEquals(10, PlanningTypes.CLASS_PLANNING.getId());
        assertEquals(20, PlanningTypes.INDIVIDUAL_PLANNING.getId());
    }

    @Test
    void fromId() {
        assertEquals(PlanningTypes.CLASS_PLANNING, PlanningTypes.fromId(10));
        assertEquals(PlanningTypes.INDIVIDUAL_PLANNING, PlanningTypes.fromId(20));
    }
}