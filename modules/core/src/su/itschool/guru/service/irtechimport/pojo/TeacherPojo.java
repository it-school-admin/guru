package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class TeacherPojo extends AbstractPojoWithId {
    public final String name;
    public final String middleName;
    public final String lastName;

    public TeacherPojo(Element teacherElement) {
        setIrTechId(teacherElement,"tid");
        name = getString(teacherElement,"firstname");
        middleName = getString(teacherElement,"middlename");
        lastName = getString(teacherElement,"lastname");
    }
}
