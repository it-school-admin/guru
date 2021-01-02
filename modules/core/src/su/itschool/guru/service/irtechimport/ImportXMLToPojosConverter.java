package su.itschool.guru.service.irtechimport;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;
import su.itschool.guru.service.irtechimport.pojo.TeacherPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

            return timeTablePojos;
        } catch (JDOMException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
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
