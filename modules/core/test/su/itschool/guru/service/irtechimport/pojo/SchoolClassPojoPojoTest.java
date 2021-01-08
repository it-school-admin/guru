package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolClassPojoPojoTest extends AbstractPojoTest {
    private static final String CLASS_XML = "<class id=\"913934\" name=\"2А\" grade=\"2\" studcnt=\"26\" boys=\"15\" girls=\"11\"> \n" +
            "\t<csg id=\"4826768\" sid=\"85825\" name=\"Изобразительное искусство\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t<csg id=\"4826769\" sid=\"85827\" name=\"Музыка\" groupid=\"\" parentsubjectid=\"\" tid=\"1251043\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "</class>";

    @Test
    void checkCreation()
    {
        SchoolClassPojo schoolClassPojo = new SchoolClassPojo(convertStringToElement(CLASS_XML));
        assertEquals(913934, schoolClassPojo.irTechId);
        assertEquals(2, schoolClassPojo.grade);
        assertEquals(Character.valueOf('А'), schoolClassPojo.letter);
        assertEquals(26, schoolClassPojo.countOfStudents);
    }

}