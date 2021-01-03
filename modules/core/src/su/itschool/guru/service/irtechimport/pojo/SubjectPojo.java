package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class SubjectPojo extends AbstractPojoWithId {
    public String name;
    public String abbr;

    public SubjectPojo(Element subjectElement) {
        setIrTechId(subjectElement,"sid");
        name = getString(subjectElement,"name");
        abbr = getString(subjectElement,"abbr");
    }
}
