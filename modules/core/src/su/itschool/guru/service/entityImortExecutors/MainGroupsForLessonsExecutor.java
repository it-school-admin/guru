package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;


public class MainGroupsForLessonsExecutor extends AbstractGroupsForLessonsExecutor {

    /*
                <class id="913935" name="2Б" grade="2" studcnt="25" boys="12" girls="13">
            <csg id="4826784" tid="1251021" sid="85831" name="Математика" groupid="" parentsubjectid="" hrsweek="5" studcnt="0"/>

     */
    public MainGroupsForLessonsExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        GroupForLesson groupForLesson = (GroupForLesson) entity;
        SchoolClass schoolClass = (SchoolClass) rootEntity;
        groupForLesson.setSchoolClass(schoolClass);
        groupForLesson.setIsFullClassGroup(true);
        groupForLesson.setSubject(getFinderService().findSubjectByIrTechId(getIntegerAttributeValue(entityInformation, "sid")));
        if(nodeNotContainsSubGroupInformation(entityInformation)) {
            groupForLesson.setTeacher(getFinderService().findTeacherByIrTechId(getIntegerAttributeValue(entityInformation, "tid")));
        }
        return groupForLesson;
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
                            "gr.isFullClassGroup = true "+
                            "AND cl.irTechId = :classIrTechId "+
                            "AND sub.irTechId = :subjectIrTechId").
                    parameter("classIrTechId", ((SchoolClass)rootEntity).getIrTechId()).
                    parameter("subjectIrTechId", getIntegerAttributeValue(entityInformation, "sid")).
                    one();

        } catch (Exception e) {
            //TODO avoid exception appearing
           // e.printStackTrace();
            return null;
        }

        return groupForLesson;
    }
}
