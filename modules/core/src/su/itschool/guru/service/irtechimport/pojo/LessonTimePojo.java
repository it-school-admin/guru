package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LessonTimePojo {
    public LocalTime startTime;
    public LocalTime endTime;
    public Integer irTechId;

    public LessonTimePojo(Element lessonTimeElement) {
        irTechId = Integer.valueOf(lessonTimeElement.getAttributeValue("id"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        startTime = LocalTime.parse(lessonTimeElement.getAttributeValue("starttime"), timeFormatter);
        endTime = LocalTime.parse(lessonTimeElement.getAttributeValue("endtime"), timeFormatter);
    }
}
