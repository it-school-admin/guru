package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class TeacherPojo extends AbstractPojoWithId {
    public String name;
    public String middleName;
    public String lastName;

    public TeacherPojo(Element teacherElement) {
        setIrTechId(teacherElement,"tid");
        name = getString(teacherElement,"firstname");
        middleName = getString(teacherElement,"middlename");
        lastName = getString(teacherElement,"lastname");
    }
}
