package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularSubgroupPojoTest extends AbstractPojoTest {

    private static final String PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML
            = "<csg id=\"4866985\" sid=\"85830\" name=\"Информатика/1 гр.\" groupid=\"80685\" parentsubjectid=\"\" tid=\"1251067\" hrsweek=\"1\" studcnt=\"17\"/>";

    private static final String PLAN_ITEM_WITH_PARENT_SUBJECT_XML
            = "<csg id=\"4866994\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.1 под\" groupid=\"81491\" parentsubjectid=\"60699\" tid=\"1327411\" hrsweek=\"3\" studcnt=\"13\"/>";
    public static final Integer CLASS_IR_TECH_ID_SAMPLE = Integer.valueOf(12345);

    @Test
    void checkCreation_group_with_plain_subject()
    {
        RegularSubgroupPojo regularSubgroupPojo = new RegularSubgroupPojo(convertStringToElement(PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(80685, regularSubgroupPojo.irTechId);
        assertEquals("1 гр.", regularSubgroupPojo.name);
    }

    @Test
    void checkCreation_group_count_of_student()
    {
        RegularSubgroupPojo regularSubgroupPojo = new RegularSubgroupPojo(convertStringToElement(PLAN_ITEM_WITH_REGULAR_SUBGROUP_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(17, regularSubgroupPojo.studentsCount);
    }

    @Test
    void checkCreation_group_with_subject_with_parent_subject()
    {
        RegularSubgroupPojo regularSubgroupPojo = new RegularSubgroupPojo(convertStringToElement(PLAN_ITEM_WITH_PARENT_SUBJECT_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(81491, regularSubgroupPojo.irTechId);
        assertEquals("англ.1 под", regularSubgroupPojo.name);
    }

    @Test
    void checkCreation_class_information()
    {
        RegularSubgroupPojo regularSubgroupPojo = new RegularSubgroupPojo(convertStringToElement(PLAN_ITEM_WITH_PARENT_SUBJECT_XML), CLASS_IR_TECH_ID_SAMPLE);
        assertEquals(CLASS_IR_TECH_ID_SAMPLE, regularSubgroupPojo.classIrTechId);
    }

}