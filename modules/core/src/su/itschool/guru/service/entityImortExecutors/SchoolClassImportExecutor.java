package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public class SchoolClassImportExecutor extends AbstractImportExecutorImpl {

    public SchoolClassImportExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        //			<class id="927307" name="1А" grade="1" studcnt="27" boys="8" girls="19">
        SchoolClass schoolClass = (SchoolClass) entity;
        schoolClass.setIrTechId(getIntegerAttributeValue(entityInformation, "id"));
        schoolClass.setClassLevel(getIntegerAttributeValue(entityInformation, "grade"));
        schoolClass.setClassName(getStringAttributeValue(entityInformation, "name"));
        schoolClass.setStudentCount(getIntegerAttributeValue(entityInformation, "studcnt"));
        schoolClass.setBoysCount(getIntegerAttributeValue(entityInformation, "boys"));
        schoolClass.setGirlsCount(getIntegerAttributeValue(entityInformation, "girls"));

        return schoolClass;
    }


    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
