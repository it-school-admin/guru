package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public abstract class AbstractPojoWithIrTechId extends AbstractPojo{
    public Integer irTechId;

    protected void setIrTechId(Element element, String fieldName)
    {
        irTechId = getInteger(element, fieldName);
    }
}
