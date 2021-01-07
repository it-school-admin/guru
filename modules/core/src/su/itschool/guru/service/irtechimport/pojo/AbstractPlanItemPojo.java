package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class AbstractPlanItemPojo extends AbstractPojoWithId
{
    public final Integer teacherId;
    public final Integer hoursPerWeek;

    protected AbstractPlanItemPojo(Element planItemElement)
    {
        setIrTechId(planItemElement, "id");
        teacherId = getInteger(planItemElement, "tid");
        hoursPerWeek = getInteger(planItemElement, "hrsweek");
    }
}
