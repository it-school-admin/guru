package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AbstractPojoTest {
    //TODO move to libruary
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


}
