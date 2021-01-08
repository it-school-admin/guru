package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RegularSubgroupPojo extends AbstractPojoWithIrTechId {
    public final String name;
    public final Integer classIrTechId;
    public final Integer studentsCount;

    public RegularSubgroupPojo(Element planItemElement, Integer classIrTechId ) {
        this.classIrTechId = classIrTechId;
        setIrTechId(planItemElement, "groupid");
        name = extractGroupName(planItemElement, hasParentSubject(planItemElement));
        studentsCount = getInteger(planItemElement, "studcnt");
    }

    private String extractGroupName(Element planItemElement, boolean hasParentSubject) {
        String fullName = getString(planItemElement, "name");
        if(!hasParentSubject)
        {
            return fullName.substring(fullName.indexOf('/')+1);
        }
        else {
            return fullName.substring(fullName.lastIndexOf('/')+1);
        }
    }

    private boolean hasParentSubject(Element planItemElement) {
        return !planItemElement.getAttributeValue("parentsubjectid").isEmpty();
    }
}
