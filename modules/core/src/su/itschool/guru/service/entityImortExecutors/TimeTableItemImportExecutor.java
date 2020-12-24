package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.entity.enums.WeekDay;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

import java.util.Map;

import static su.itschool.guru.entity.enums.WeekDay.fromId;

public class TimeTableItemImportExecutor extends AbstractImportExecutorImpl{
    private final WeekDay day;
    private final Integer lessonNumber;

    public TimeTableItemImportExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager, Integer day, Integer lessonNumber) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
        this.day = fromId(day);
        this.lessonNumber = lessonNumber;
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        TimeTableTemplateItem timeTableTemplateItem = (TimeTableTemplateItem) entity;
        timeTableTemplateItem.setWeekDay(day);
        LessonsPlanningItem lessonsPlanningItem = getFinderService().getPlanningItemByIrTechId(getIntegerAttributeValue(entityInformation, "id"));
        timeTableTemplateItem.setPlanningItem(lessonsPlanningItem);
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
