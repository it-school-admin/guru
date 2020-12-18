package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public abstract class AbstractGroupsForLessonsExecutor extends AbstractImportExecutorImpl {
    public AbstractGroupsForLessonsExecutor(Class entityClass, EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService, DataManager dataManager) {
        super(entityClass, entitiesByIrTechIdFinderService, dataManager);
    }

    protected boolean nodeNotContainsSubGroupInformation(Node entityInformation) {
        return getStringAttributeValue(entityInformation, "groupid").isEmpty();
    }
}