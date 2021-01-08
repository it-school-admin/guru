package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RegularPlanItemPojo extends AbstractPlanItemPojoIrTech {
    public final Integer subjectId;
    public final Integer subGroupId;

    public RegularPlanItemPojo(Element planItemElement, Integer classIrTechId) {
        super(planItemElement, classIrTechId);
        subjectId = getInteger(planItemElement, "sid");
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
