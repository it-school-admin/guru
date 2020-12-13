package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Subject;

public class SubjectImportExecutor<Teacher> extends AbstractImportExecutorImpl {
    public SubjectImportExecutor(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation) {
        //		<subject sid="92764" name="Астрономия" abbr="Астр">
        Subject subject = (Subject) entity;
        subject.setIrTechId(getID(entityInformation, "sid"));
        subject.setSubjectName(getStringAttributeValue(entityInformation, "name"));
        subject.setShortenedName(getStringAttributeValue(entityInformation, "abbr"));
        return entity;
    }

}
