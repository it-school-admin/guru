package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanItemPojoTest extends AbstractPojoTest {
    private static final String PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML
            = "<csg id=\"4866985\" sid=\"85830\" name=\"Информатика/1 гр.\" groupid=\"80685\" parentsubjectid=\"\" tid=\"1251067\" hrsweek=\"1\" studcnt=\"17\"/>";

    private static final String PLAN_ITEM_WITHOUT_SUBGROUP
            = "<csg id=\"4826768\" sid=\"85825\" name=\"Изобразительное искусство\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>";


    public static final Integer CLASS_IR_TECH_ID_SAMPLE = Integer.valueOf(12345);

    @Test
    void checkCreation_group_with_plain_subject()
    {
        PlanItemPojo planItemPojo = new PlanItemPojo(convertStringToElement(PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(4866985, planItemPojo.irTechId);
        assertEquals(CLASS_IR_TECH_ID_SAMPLE, planItemPojo.classIrTechId);
        assertEquals(85830, planItemPojo.subjectId);
        assertEquals(1251067, planItemPojo.teacherId);
    }

    @Test
    void checkCreation_check_subgroup()
    {
        PlanItemPojo planItemPojo = new PlanItemPojo(convertStringToElement(PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(80685, planItemPojo.subGroupId);
    }

    @Test
    void checkCreation_check_without_subgroup()
    {
        PlanItemPojo planItemPojo = new PlanItemPojo(convertStringToElement(PLAN_ITEM_WITHOUT_SUBGROUP), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(null, planItemPojo.subGroupId);
    }

}