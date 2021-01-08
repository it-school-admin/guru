package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class SubjectPojo extends AbstractPojoWithIrTechId {
    public final String name;
    public final String abbr;
    private Integer parentSubject;

    public SubjectPojo(Element subjectElement) {
        setIrTechId(subjectElement,"sid");
        name = getString(subjectElement,"name");
        abbr = getString(subjectElement,"abbr");
    }

    public void setParentSubject(Integer parentSubject)
    {
        this.parentSubject = parentSubject;
    }

    public Integer getParentSubject() {
        return parentSubject;
    }
}
