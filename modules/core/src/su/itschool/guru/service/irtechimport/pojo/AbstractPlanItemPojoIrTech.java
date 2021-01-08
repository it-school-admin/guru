package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class AbstractPlanItemPojoIrTech extends AbstractPojoWithIrTechId
{
    public final Integer classIrTechId;
    public final Integer teacherId;
    public final Integer hoursPerWeek;

    protected AbstractPlanItemPojoIrTech(Element planItemElement, Integer classIrTechId)
    {
        setIrTechId(planItemElement, "id");
        teacherId = getInteger(planItemElement, "tid");
        hoursPerWeek = getInteger(planItemElement, "hrsweek");
        this.classIrTechId = classIrTechId;
    }
}
