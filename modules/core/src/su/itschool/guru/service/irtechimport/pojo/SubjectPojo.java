package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class SubjectPojo extends AbstractPojoWithId {
    public final String name;
    public final String abbr;

    public SubjectPojo(Element subjectElement) {
        setIrTechId(subjectElement,"sid");
        name = getString(subjectElement,"name");
        abbr = getString(subjectElement,"abbr");
    }
}
