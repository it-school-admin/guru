package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Teacher;

import javax.validation.constraints.NotNull;

public abstract class AbstractImportExecutorImpl<T extends StandardEntity> implements EntityImportExecutor{

    private Class<T> entityClass;

    public AbstractImportExecutorImpl(Class<T> entityClass){

        this.entityClass = entityClass;
    }

    @Override
    public final T execute(Node entityInformation, DataManager dataManager) {
        T entity = dataManager.create(entityClass);
        dataManager.commit(setEntityFields(entity, entityInformation));
        return entity;
    }

    protected abstract StandardEntity setEntityFields(T entity, Node entityInformation);


    protected final String getStringAttributeValue(Node entityInformation, String fieldName) {
        return entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue();
    }

    protected final Integer getIntegerAttributeValue(Node entityInformation, String fieldName) {
        return Integer.valueOf(entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

    @NotNull
    protected final Integer getID(Node entityInformation, String fieldName) {
        return Integer.valueOf(entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

}
