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
    public T execute(Node entityInformation, DataManager dataManager) {
        T entity = dataManager.create(entityClass);

        setEntityFields(entity, entityInformation);
        dataManager.commit(entity);
        return entity;
    }

    protected abstract void setEntityFields(T entity, Node entityInformation);


    protected String getStringAttributeValue(Node entityInformation, String fieldName) {
        return entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue();
    }

    @NotNull
    protected Integer getID(Node entityInformation, String fieldName) {
        return Integer.valueOf(entityInformation.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

}
