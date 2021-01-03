package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class SchoolClassPojo extends AbstractPojoWithId {
    public Integer grade;
    public Character letter;
    public Integer countOfStudents;

    public SchoolClassPojo(Element classElement) {
        setIrTechId(classElement, "id");
        grade = getInteger(classElement, "grade");
        letter = getClassLetter(classElement);
        countOfStudents = getInteger(classElement,"studcnt");
    }

    private char getClassLetter(Element classElement) {
        String className = getString(classElement, "name");
        return className.charAt(className.length() - 1);
    }
}
