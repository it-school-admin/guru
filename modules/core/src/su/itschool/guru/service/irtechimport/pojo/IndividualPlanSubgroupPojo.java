package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class IndividualPlanSubgroupPojo extends AbstractPojo{
    public final Integer planItemIrTechId;
    public final Integer defaultSchoolClassIrTechId;
    public String name;
    public final Integer studentsCount;

    public IndividualPlanSubgroupPojo(Element planItemElement, Integer schoolClassIrTechId) {
        planItemIrTechId = getInteger(planItemElement, "id");
        defaultSchoolClassIrTechId = schoolClassIrTechId;
        name = extractName(getString(planItemElement, "name"));
        studentsCount = getInteger(planItemElement, "studcnt");
    }

    private String extractName(String name) {
        return name.substring(name.lastIndexOf('/')+1);
    }
}
