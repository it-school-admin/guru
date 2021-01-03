package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class PlanItemPojo extends AbstractPojoWithId{
    public final Integer classIrTechId;
    public final Integer subjectId;
    public final Integer teacherId;
    public final Integer subGroupId;

    public PlanItemPojo(Element planItemElement, Integer classIrTechId) {
        this.classIrTechId = classIrTechId;
        setIrTechId(planItemElement, "id");
        subjectId = getInteger(planItemElement, "sid");
        teacherId = getInteger(planItemElement, "tid");
        String subGroupId = getString(planItemElement, "groupid");
        if(subGroupId.isEmpty())
        {
            this.subGroupId = null;
        }
        else
        {
            this.subGroupId = Integer.valueOf(subGroupId);
        }
    }
}
