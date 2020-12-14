package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public class SubGroupsForLessonsExecutor extends AbstractGroupsForLessonsExecutor {
//		<csg id="4866912" tid="1322890" sid="89298" name="Иностранный язык/Иностранный язык (Английский язык)/англ.1 под" groupid="81491" parentsubjectid="60699" hrsweek="2" studcnt="13"/>

    public SubGroupsForLessonsExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        GroupForLesson parentGroup = (GroupForLesson) rootEntity;
        GroupForLesson subGroup = (GroupForLesson) entity;
        subGroup.setSchoolClass(parentGroup.getSchoolClass());
        subGroup.setSubGroupName(getSubGroupNameFromIrTechSubGroupName(""));
        /*
        groupForLesson.setGroupName(schoolClass.getClassName());
        groupForLesson.setIsFullClassGroup(true);
        groupForLesson.setSubject(getFinderService().findSubjectByIrTechId(getIntegerAttributeValue(entityInformation, "sid")));
        if(nodeNotContainsSubGroupInformation(entityInformation)) {
            groupForLesson.setTeacher(getFinderService().findTeacherByIrTechId(getIntegerAttributeValue(entityInformation, "tid")));
        }

         */
        return null;
    }

    private String getSubGroupNameFromIrTechSubGroupName(String irTechName) {
        return irTechName.substring(getLastSlashPos(irTechName)+1, irTechName.length()-1);
    }

    private int getLastSlashPos(String irTechName) {
        int firstIndex = irTechName.indexOf("/");
        if (firstIndex == -1) {
            return -1;
        } else {
            int secondIndex = getLastSlashPos(irTechName.substring(firstIndex));
            if (secondIndex == -1)
            {
                return firstIndex;
            }
            else {
                return secondIndex;
            }
        }


    }

    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        //find subgroup by IrTech ID
        return null;
    }
}
