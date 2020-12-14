package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.service.EntitiesByIrTechIdFinderService;

public abstract class AbstractImportExecutorImpl<T extends StandardEntity> implements EntityImportExecutor{

    private Class<T> entityClass;
    private final EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService;
    private final DataManager dataManager;

    public AbstractImportExecutorImpl(Class<T> entityClass,
                                      EntitiesByIrTechIdFinderService entitiesByIrTechIdFinderService,
                                      DataManager dataManager){

        this.entityClass = entityClass;
        this.entitiesByIrTechIdFinderService = entitiesByIrTechIdFinderService;
        this.dataManager = dataManager;
    }

    @Override
    public final T execute(Node rootNode, StandardEntity rootEntity, Node entityInformationNode) {
        T entity = (T) findEntity(rootNode, rootEntity, entityInformationNode);

        if(entity == null)
        {
            entity = dataManager.create(entityClass);
            dataManager.commit(setEntityFields(entity, entityInformationNode, rootNode, rootEntity));
        }
        return entity;
    }

    protected final DataManager getDataManager(){
        return dataManager;
    }

    protected abstract StandardEntity setEntityFields(T entity, Node entityInformation, Node rootNode, StandardEntity rootEntity);


    protected final String getStringAttributeValue(Node entityInformation, String fieldName) {
        return entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue();
    }

    protected final Integer getIntegerAttributeValue(Node entityInformation, String fieldName) {
        System.out.println(entityInformation.getNodeName()+" "+ fieldName+" "+ entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
        return Integer.valueOf(entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

    public EntitiesByIrTechIdFinderService getFinderService() {
        return entitiesByIrTechIdFinderService;
    }
}
