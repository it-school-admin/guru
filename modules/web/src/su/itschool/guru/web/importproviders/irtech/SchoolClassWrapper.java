package su.itschool.guru.web.importproviders.irtech;

import org.jdom2.Element;

public class SchoolClassWrapper {
    private final Integer classId;
    private final String className;
    private final Integer grade;
    private final char letter;

    public SchoolClassWrapper(Element classElement) {
        classId = Integer.valueOf(classElement.getAttributeValue("id"));
        className = classElement.getAttributeValue("name");
        grade = Integer.valueOf(classElement.getAttributeValue("grade"));
        letter = className.charAt(className.length() - 1);
    }

    public Integer getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public Integer getGrade() {
        return grade;
    }

    public char getLetter() {
        return letter;
    }
}
