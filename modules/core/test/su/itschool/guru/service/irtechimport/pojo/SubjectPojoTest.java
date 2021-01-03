package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectPojoTest extends AbstractPojoTest {
    private static final String SUBJECT_XML = "<subject sid=\"92764\" name=\"математика\" abbr=\"матем.\">\n" +
            "\t\t\t<teacher tid=\"1251004\" />\n" +
            "\t\t\t<teacher tid=\"1251036\" /></subject>";

    @Test
    void checkCreation()
    {
        SubjectPojo subjectPojo = new SubjectPojo(convertStringToElement(SUBJECT_XML));
        assertEquals(92764, subjectPojo.irTechId);
        assertEquals("математика", subjectPojo.name);
        assertEquals("матем.", subjectPojo.abbr);
    }


}