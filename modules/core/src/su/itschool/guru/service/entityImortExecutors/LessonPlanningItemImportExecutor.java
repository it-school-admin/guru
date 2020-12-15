package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public class LessonPlanningItemImportExecutor extends AbstractImportExecutorImpl {
//		<csg id="4867135" tid="1322890" sid="89298" name="Иностранный язык/Иностранный язык (Английский язык)/англ.1 под" groupid="81491" parentsubjectid="60699" hrsweek="3" studcnt="13"/>
    public LessonPlanningItemImportExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        LessonsPlanningItem lessonsPlanningItem = (LessonsPlanningItem) entity;
        SchoolClass schoolClass = (SchoolClass) rootEntity;
        lessonsPlanningItem.setGroupOfLearning(findGroup(entityInformation, schoolClass));
        lessonsPlanningItem.setIrTechID(getIntegerAttributeValue(entityInformation, "id"));
        lessonsPlanningItem.setHoursPerWeek(getIntegerAttributeValue(entityInformation, "hrsweek"));
        return lessonsPlanningItem;
    }

    private GroupForLesson findGroup(Node entityInformation, SchoolClass schoolClass) {
        if (isFullClassGroup(entityInformation))
        {
            return getFinderService().findMainLearningGroup(schoolClass.getIrTechId(), getIntegerAttributeValue(entityInformation, "sid"));
        }
        else
        {
            return getFinderService().findLearningSubGroup(getIntegerAttributeValue(entityInformation, "groupid"), schoolClass,getIntegerAttributeValue(entityInformation, "sid"));
        }
    }

    private boolean isFullClassGroup(Node entityInformation) {
        return getStringAttributeValue(entityInformation, "groupid").isEmpty();
    }


    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
