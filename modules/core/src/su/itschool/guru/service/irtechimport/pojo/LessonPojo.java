package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class LessonPojo extends AbstractPojo{
    public final Integer planItemId;
    public final Integer dayOfWeekNumber;
    public final Integer lessonNumber;
    public final Integer roomId;

    public LessonPojo(Element lessonElement, Integer lessonNumber, Integer dayOfWeekNumber) {
        planItemId = getInteger(lessonElement, "id");
        this.lessonNumber = lessonNumber;
        this.dayOfWeekNumber = dayOfWeekNumber;
        String roomIdAttributeValue = getString(lessonElement, "roomid");
        if(roomIdAttributeValue==null || roomIdAttributeValue.isEmpty())
        {
            this.roomId = null;
        }
        else
        {
            this.roomId = Integer.valueOf(roomIdAttributeValue);
        }
    }
}
