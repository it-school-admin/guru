package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherPojoTest extends AbstractPojoTest{
    private static final String TEACHER_XML = "<teacher tid=\"1296030\" firstname=\"Павел\" middlename=\"Владимирович\" lastname=\"Александров\"/>";

    @Test
    void checkCreation()
    {
        TeacherPojo teacherPojo = new TeacherPojo(convertStringToElement(TEACHER_XML));
        assertEquals(1296030, teacherPojo.irTechId);
        assertEquals("Павел", teacherPojo.name);
        assertEquals("Владимирович", teacherPojo.middleName);
        assertEquals("Александров", teacherPojo.lastName);
    }

}