package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;


public class MainGroupsForLessonsExecutor extends AbstractImportExecutorImpl{

    public MainGroupsForLessonsExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        GroupForLesson groupForLesson = (GroupForLesson) entity;
        SchoolClass schoolClass = (SchoolClass) rootEntity;
        groupForLesson.setSchoolClass(schoolClass);
        groupForLesson.setGroupName(schoolClass.getClassName());
        groupForLesson.setIsFullClassGroup(true);
        groupForLesson.setTeacher(getFinderService().findTeacherByIrTechId(getIntegerAttributeValue(entityInformation, "tid")));
        groupForLesson.setSubject(getFinderService().findSubjectByIrTechId(getIntegerAttributeValue(entityInformation, "sid")));
        return groupForLesson;
    }


    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        GroupForLesson groupForLesson;
        try {
            groupForLesson = getDataManager().
                    load(GroupForLesson.class).
                    viewProperties("irTechId").
                    query("select id from guru_GroupForLesson as g " +
                            "INNER JOIN guru_SchoolClass as c " +
                            "where g.schoolClass = c.id" +
                            "AND c.irTechId = :irTechId").
                    parameter("irTechId", ((SchoolClass)rootEntity).getIrTechId()).
                    one();
        } catch (Exception e) {
            //TODO
            return null;
        }

        return groupForLesson;
    }
}
