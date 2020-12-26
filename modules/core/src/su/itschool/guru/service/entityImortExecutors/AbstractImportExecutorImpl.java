package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.service.IrTechImportFinderService;

public abstract class AbstractImportExecutorImpl<T extends StandardEntity> implements EntityImportExecutor{

    private Class<T> entityClass;
    private final IrTechImportFinderService irTechImportFinderService;
    private final DataManager dataManager;

    public AbstractImportExecutorImpl(Class<T> entityClass,
                                      IrTechImportFinderService irTechImportFinderService,
                                      DataManager dataManager){

        this.entityClass = entityClass;
        this.irTechImportFinderService = irTechImportFinderService;
        this.dataManager = dataManager;
    }

    @Override
    public T execute(Node rootNode, StandardEntity rootEntity, Node entityInformationNode) {
        //TODO
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
        //TODO
        Node attributeNode = entityInformation.getAttributes().getNamedItem(fieldName);
        if (attributeNode != null)
        {
            return entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue();
        }
        else
        {
            return "";
        }
    }

    protected final Integer getIntegerAttributeValue(Node entityInformation, String fieldName) {
        return Integer.valueOf(entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

    public IrTechImportFinderService getFinderService() {
        return irTechImportFinderService;
    }

    public boolean needToBeCreated(Node entityInformation)
    {
        return true;
    }
}
