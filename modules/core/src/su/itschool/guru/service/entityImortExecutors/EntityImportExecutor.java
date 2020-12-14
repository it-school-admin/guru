package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;

public interface EntityImportExecutor<T extends StandardEntity> {
    T execute(Node rootNode, StandardEntity rootEntity, Node entityInformationNode);
    T findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation);
}
