package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividualPlanSubgroupPojoTest extends AbstractPojoTest {
    public static final String PLAN_ITEM_ID = "5069689";
    private static final String INDIVIDUAL_PLAN_ITEM_XML_SIMPLE_SUBJECT = "<csg id=\"" + PLAN_ITEM_ID + "\" tid=\"1279264\" name=\"Элективный курс история/10А11А\" sid=\"87211\" studcnt=\"15\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"1\" /> ";
    private static final String INDIVIDUAL_PLAN_ITEM_XML_SUBJECT_WITH_PARENT = "<csg id=\"4963529\" tid=\"1267155\" name=\"Иностранный язык/Иностранный язык (Английский язык)/У\" sid=\"89298\" studcnt=\"10\" hrsweek=\"6\" parentsubjectid=\"1\" groupid=\"1\" /> ";
    private static final String INDIVIDUAL_PLAN_ITEM_XML_SUBJECT_WITH_GROUPS = "<csg id=\"4993560\" tid=\"1251067\" name=\"Информатика/11Б-2\" sid=\"85830\" studcnt=\"12\" hrsweek=\"1\" parentsubjectid=\"1\" groupid=\"2\" />";
    public static final Integer DEFAULT_SCHOOL_CLASS_IR_TECH_ID = Integer.valueOf(12345);

    @Test
    void checkCreation()
    {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(
                convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML_SIMPLE_SUBJECT),
                DEFAULT_SCHOOL_CLASS_IR_TECH_ID);
        assertEquals(Integer.valueOf(PLAN_ITEM_ID), individualPlanSubgroupPojo.planItemIrTechId);
        Assertions.assertEquals(DEFAULT_SCHOOL_CLASS_IR_TECH_ID, individualPlanSubgroupPojo.defaultSchoolClassIrTechId);
        Assertions.assertEquals(87211, individualPlanSubgroupPojo.subject);
    }

    @Test
    void checkCreation_check_students_count()
    {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(
                convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML_SIMPLE_SUBJECT),
                DEFAULT_SCHOOL_CLASS_IR_TECH_ID);
        assertEquals(15, individualPlanSubgroupPojo.studentsCount);
    }

    @Test
    void checkCreation_check_name()
    {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(
                convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML_SIMPLE_SUBJECT),
                DEFAULT_SCHOOL_CLASS_IR_TECH_ID);
        assertEquals("10А11А", individualPlanSubgroupPojo.name);
    }

    @Test
    void checkCreation_check_name_with_parent_subject()
    {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(
                convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML_SUBJECT_WITH_PARENT),
                DEFAULT_SCHOOL_CLASS_IR_TECH_ID);
        assertEquals("У", individualPlanSubgroupPojo.name);
    }

    @Test
    void checkCreation_check_name_with_subgroups()
    {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(
                convertStringToElement(INDIVIDUAL_PLAN_ITEM_XML_SUBJECT_WITH_GROUPS),
                DEFAULT_SCHOOL_CLASS_IR_TECH_ID);
        assertEquals("11Б-2", individualPlanSubgroupPojo.name);
    }
}