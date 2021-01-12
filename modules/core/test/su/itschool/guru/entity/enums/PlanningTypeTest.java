package su.itschool.guru.entity.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningTypeTest {

    @Test
    void testValues(){
        assertEquals(10, PlanningType.CLASS_PLANNING.getId());
        assertEquals(20, PlanningType.INDIVIDUAL_PLANNING.getId());
    }

    @Test
    void fromId() {
        assertEquals(PlanningType.CLASS_PLANNING, PlanningType.fromId(10));
        assertEquals(PlanningType.INDIVIDUAL_PLANNING, PlanningType.fromId(20));
    }
}