package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RootSubjectPojoTest extends AbstractPojoTest {

    private static final String PLANNING_ITEM_WITH_PAREN_SUBJECT_XML = "<csg id=\"4955495\" sid=\"89298\" name=\"Иностранный язык/Иностранный язык (Английский язык)/англ.2 под\" groupid=\"81492\" parentsubjectid=\"60699\" tid=\"1251087\" hrsweek=\"3\" studcnt=\"12\"/>";

    @Test
    void checkCreation()
    {
        RootSubjectPojo rootSubjectPojo = new RootSubjectPojo(convertStringToElement(PLANNING_ITEM_WITH_PAREN_SUBJECT_XML));
        assertEquals(60699, rootSubjectPojo.irTechId);
        assertEquals("Иностранный язык", rootSubjectPojo.name);
    }

}