package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public abstract class AbstractPojoWithId  extends AbstractPojo{
    public Integer irTechId;

    protected void setIrTechId(Element element, String fieldName)
    {
        irTechId = getInteger(element, fieldName);
    }
}
