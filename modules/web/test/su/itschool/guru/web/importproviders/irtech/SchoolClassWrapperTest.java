package su.itschool.guru.web.importproviders.irtech;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SchoolClassWrapperTest {

    public static final String SCHOOL_CLASS_XML = "<class id=\"927307\" name=\"1А\" grade=\"1\" studcnt=\"27\" boys=\"8\" girls=\"19\"> \n" +
            "\t\t<csg id=\"4743510\" sid=\"85825\" name=\"Изобразительное искусство\" groupid=\"\" parentsubjectid=\"\" tid=\"1251015\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "\t\t<csg id=\"4743511\" sid=\"85827\" name=\"Музыка\" groupid=\"\" parentsubjectid=\"\" tid=\"1251043\" hrsweek=\"1\" studcnt=\"0\"/>\n" +
            "</class>";

    protected final Element convertStringToElement(String lessonTimeXml) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document build = saxBuilder.build(new ByteArrayInputStream(lessonTimeXml.getBytes(StandardCharsets.UTF_8)));
            return build.getRootElement();
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void creationTest()
    {
        SchoolClassWrapper schoolClassWrapper = new SchoolClassWrapper(convertStringToElement(SCHOOL_CLASS_XML));
        assertEquals(927307, schoolClassWrapper.getClassId());
        assertEquals("1А", schoolClassWrapper.getClassName());
        assertEquals(1, schoolClassWrapper.getGrade());
        assertEquals('А', schoolClassWrapper.getLetter());
    }

}