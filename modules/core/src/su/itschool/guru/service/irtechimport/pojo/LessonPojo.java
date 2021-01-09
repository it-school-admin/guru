package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

import java.util.Map;

public class LessonPojo extends AbstractPojo{
    public final Integer planItemId;
    public final Integer dayOfWeekNumber;
    public final Integer lessonNumber;
    public final Integer roomId;
    public final Integer irTechClassId;

    public LessonPojo(Element lessonElement,
                      Integer lessonNumber,
                      Integer dayOfWeekNumber,
                      Map<Integer, RegularPlanItemPojo> regularPlanItems,
                      Map<Integer, IndividualPlanItemPojo> individualPlanItems) {
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
        RegularPlanItemPojo regularPlanItemPojo = regularPlanItems.get(planItemId);
        if (regularPlanItemPojo != null)
        {
            irTechClassId = regularPlanItemPojo.classIrTechId;
        }
        else
        {
            IndividualPlanItemPojo individualPlanItemPojo = individualPlanItems.get(planItemId);
            if(individualPlanItemPojo != null)
            {
                irTechClassId = individualPlanItemPojo.classIrTechId;
            }
            else {
                //TODO message
                throw new IllegalStateException();
            }
        }
    }
}
