package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public class SubGroupsForLessonsExecutor extends AbstractGroupsForLessonsExecutor {
//		<csg id="4866912" tid="1322890" sid="89298" name="Иностранный язык/Иностранный язык (Английский язык)/англ.1 под" groupid="81491" parentsubjectid="60699" hrsweek="2" studcnt="13"/>

    public SubGroupsForLessonsExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        SchoolClass schoolClass = (SchoolClass) rootEntity;
        GroupForLesson subGroup = (GroupForLesson) entity;
        subGroup.setSchoolClass(schoolClass);
        if(schoolClass.getClassLevel()<10)
        {
            subGroup.setSubGroupName(getSubGroupNameFromIrTechSubGroupName(getStringAttributeValue(entityInformation, "name")));
        }
        else
        {
            subGroup.setSubGroupName(getStringAttributeValue(entityInformation, "name"));
        }
        subGroup.setGroupIrTechName(getStringAttributeValue(entityInformation, "name"));
        subGroup.setGroupIrTechId(getIntegerAttributeValue(entityInformation, "groupid"));
        subGroup.setIsFullClassGroup(false);
        subGroup.setSubject(getFinderService().findSubjectByIrTechId(getIntegerAttributeValue(entityInformation, "sid")));
        subGroup.setTeacher(getFinderService().findTeacherByIrTechId(getIntegerAttributeValue(entityInformation, "tid")));
        subGroup.setParentGroup(getFinderService().findMainGroupByClassIrTechID(schoolClass.getIrTechId()));

        return subGroup;
    }

    String getSubGroupNameFromIrTechSubGroupName(String irTechName) {
        return irTechName.substring(getLastSlashPos(irTechName)+1, irTechName.length());
    }

    private int getLastSlashPos(String irTechName) {
        int firstIndex = irTechName.indexOf("/");
        if (firstIndex == -1) {
            return -1;
        } else {
            int secondIndex = getLastSlashPos(irTechName.substring(firstIndex+1));
            if (secondIndex == -1)
            {
                return firstIndex;
            }
            else {
                return firstIndex + secondIndex+1;
            }
        }


    }

    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        GroupForLesson groupForLesson;
        try {

            groupForLesson = getDataManager().
                    load(GroupForLesson.class).
                    query("select gr from guru_GroupForLesson as gr " +
                            "JOIN gr.schoolClass cl " +
                            "JOIN gr.subject sub "+
                            "WHERE " +
                            "gr.isFullClassGroup = false "+
                            "AND cl.irTechId = :classIrTechId "+
                            "AND gr.groupIrTechId = :groupIrTechId "+
                            "AND sub.irTechId = :subjectIrTechId").
                    parameter("classIrTechId", ((SchoolClass)rootEntity).getIrTechId()).
                    parameter("groupIrTechId", getIntegerAttributeValue(entityInformation, "groupid")).
                    parameter("subjectIrTechId", getIntegerAttributeValue(entityInformation, "sid")).
                    one();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return groupForLesson;
    }

    public boolean needToBeCreated(Node entityInformation)
    {
        return !getStringAttributeValue(entityInformation, "groupid").isEmpty();
    }

}
