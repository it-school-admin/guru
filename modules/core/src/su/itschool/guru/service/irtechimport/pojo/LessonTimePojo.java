package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LessonTimePojo extends AbstractPojoWithId {
    public final LocalTime startTime;
    public final LocalTime endTime;
    public final Integer lessonNumber;

    public LessonTimePojo(Element lessonTimeElement) {
        setIrTechId(lessonTimeElement,"id");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        startTime = LocalTime.parse(lessonTimeElement.getAttributeValue("starttime"), timeFormatter);
        endTime = LocalTime.parse(lessonTimeElement.getAttributeValue("endtime"), timeFormatter);
        lessonNumber = getInteger(lessonTimeElement, "number");
    }
}
