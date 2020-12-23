package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

import java.util.Map;

public class TimeTableItemImportExecutor extends AbstractImportExecutorImpl{
    private final Integer day;
    private final Integer lessonNumber;

    public TimeTableItemImportExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager, Integer day, Integer lessonNumber) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
        this.day = day;
        this.lessonNumber = lessonNumber;
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        TimeTableTemplateItem timeTableTemplateItem = (TimeTableTemplateItem) entity;
        timeTableTemplateItem.setDayOfWeek(getFinderService().getWeekDay(day));
        LessonsPlanningItem lessonsPlanningItem = getFinderService().getPlanningItemByIrTechId(getIntegerAttributeValue(entityInformation, "id"));
        timeTableTemplateItem.setPlanningItem(lessonsPlanningItem);
        timeTableTemplateItem.setGroupForLesson(lessonsPlanningItem.getGroupOfLearning());
        String roomId = getStringAttributeValue(entityInformation, "roomid");
        if(!roomId.isEmpty())
        {
            timeTableTemplateItem.setRoom(getFinderService().getRoomByIrTechId(Integer.valueOf(roomId)));
        }
        timeTableTemplateItem.setNumberOfLesson(lessonNumber);
        return timeTableTemplateItem;
    }

    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
