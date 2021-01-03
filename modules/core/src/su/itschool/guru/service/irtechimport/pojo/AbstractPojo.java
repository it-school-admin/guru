package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public abstract class AbstractPojo {
    protected final Integer getInteger(Element element, String fieldName) {
        return Integer.valueOf(element.getAttributeValue(fieldName));
    }

    protected final String getString(Element element, String fieldName) {
        return element.getAttributeValue(fieldName);
    }

}
