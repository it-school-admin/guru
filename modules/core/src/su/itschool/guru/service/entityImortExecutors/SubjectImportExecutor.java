package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.service.IrTechImportFinderService;

public class SubjectImportExecutor<Teacher> extends AbstractImportExecutorImpl {


    public SubjectImportExecutor(Class entityClass, IrTechImportFinderService irTechImportFinderService, DataManager dataManager) {
        super(entityClass, irTechImportFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        //		<subject sid="92764" name="Астрономия" abbr="Астр">
        Subject subject = (Subject) entity;
        subject.setIrTechId(getIntegerAttributeValue(entityInformation, "sid"));
        subject.setSubjectName(getStringAttributeValue(entityInformation, "name"));
        subject.setShortenedName(getStringAttributeValue(entityInformation, "abbr"));
        return entity;
    }

    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
