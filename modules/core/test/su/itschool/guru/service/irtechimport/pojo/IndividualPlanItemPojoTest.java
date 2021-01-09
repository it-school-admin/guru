package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividualPlanItemPojoTest extends AbstractPojoTest{
    static private final String INDIVIDUAL_PLAN_ITEM_XML = "<csg id=\"5079239\" tid=\"1279263\" name=\"Индивидуальный проект/10АБ\" sid=\"282687\" studcnt=\"36\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" />";
    public static final int CLASS_IR_TECH_ID = 111;

    @Test
    void checkCreation_group_with_plain_subject()
    {
        IndividualPlanItemPojo individualPlanItemPojo = new IndividualPlanItemPojo(convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML), CLASS_IR_TECH_ID);
        assertEquals(5079239, individualPlanItemPojo.irTechId);
        assertEquals(1279263, individualPlanItemPojo.teacherId);
        assertEquals(1, individualPlanItemPojo.hoursPerWeek);
        assertEquals(CLASS_IR_TECH_ID, individualPlanItemPojo.classIrTechId);
    }

}