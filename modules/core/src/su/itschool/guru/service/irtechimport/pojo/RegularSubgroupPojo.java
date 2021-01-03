package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RegularSubgroupPojo extends AbstractPojoWithId{
    public String name;

    public RegularSubgroupPojo(Element planItemElement) {
        setIrTechId(planItemElement, "groupid");
        name = extractGroupName(planItemElement, hasParentSubject(planItemElement));
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
