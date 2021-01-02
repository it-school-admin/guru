package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class TeacherPojo {
    public Integer irTechId;
    public String name;
    public String middleName;
    public String lastName;

    public TeacherPojo(Element teacherElement) {
        irTechId = Integer.valueOf(teacherElement.getAttributeValue("tid"));
        name = teacherElement.getAttributeValue("firstname");
        middleName = teacherElement.getAttributeValue("middlename");
        lastName = teacherElement.getAttributeValue("lastname");
    }
}
