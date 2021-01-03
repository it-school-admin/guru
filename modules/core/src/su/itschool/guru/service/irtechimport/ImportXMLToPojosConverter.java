package su.itschool.guru.service.irtechimport;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import su.itschool.guru.service.irtechimport.pojo.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImportXMLToPojosConverter {
    public TimeTablePojos importData(InputStream inputStream) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            TimeTablePojos timeTablePojos = new TimeTablePojos();
            Document xmlDocument = saxBuilder.build(inputStream);
            Element rootElement = xmlDocument.getRootElement();
            fillLessonsPojos(rootElement, timeTablePojos);
            fillTeachersPojos(rootElement, timeTablePojos);
            fillSubjectsPojos(rootElement, timeTablePojos);
            fillRoomsPojos(rootElement, timeTablePojos);
            fillClassesPojos(rootElement, timeTablePojos);

            return timeTablePojos;
        } catch (JDOMException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void fillClassesPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> classElements = rootElement.getChild("Plan").getChildren("class");
        for (Element classElement: classElements)
        {
            SchoolClassPojo schoolClassPojo = new SchoolClassPojo(classElement);
            timeTablePojos.classes.put(schoolClassPojo.irTechId, schoolClassPojo);
        }
    }

    private void fillRoomsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> roomElements = rootElement.getChild("Rooms").getChildren("room");
        for (Element roomElement: roomElements)
        {
            RoomPojo roomPojo = new RoomPojo(roomElement);
            timeTablePojos.rooms.put(roomPojo.irTechId, roomPojo);
        }

    }

    private void fillSubjectsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> subjectElements = rootElement.getChild("subjects").getChildren("subject");
        for (Element subjectElement: subjectElements)
        {
            SubjectPojo subjectPojo = new SubjectPojo(subjectElement);
            timeTablePojos.subjects.put(subjectPojo.irTechId, subjectPojo);
        }
    }

    private void fillTeachersPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> teacherElements = rootElement.getChild("teachers").getChildren("teacher");
        for (Element teacherElement: teacherElements)
        {
            TeacherPojo teacherPojo = new TeacherPojo(teacherElement);
            timeTablePojos.teachers.put(teacherPojo.irTechId, teacherPojo);
        }

    }

    private void fillLessonsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> lessonTimeElements = rootElement.getChild("LessonTimes").getChildren("LessonTime");
        for (Element lessonTimeElement: lessonTimeElements)
        {
            byte shift = Byte.valueOf(lessonTimeElement.getAttributeValue("sm"));
            LessonTimePojo lessonTimePojo = new LessonTimePojo(lessonTimeElement);
            if(shift == 1)
            {
                timeTablePojos.firstShiftLessonsTimes.put(lessonTimePojo.irTechId, lessonTimePojo);
            }
            else
            {
                timeTablePojos.secondShiftLessonsTimes.put(lessonTimePojo.irTechId, lessonTimePojo);
            }
        }

    }
}
