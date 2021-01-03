package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RootSubjectPojo extends AbstractPojoWithId{
    public String name;

    public RootSubjectPojo(Element planItemElement) {
        setIrTechId(planItemElement, "parentsubjectid");
        name = extractRootSubjectName(getString(planItemElement, "name"));
    }

    private String extractRootSubjectName(String name) {
        return name.substring(0,name.indexOf('/'));
    }
}
