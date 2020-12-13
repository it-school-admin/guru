package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Teacher;

public class TeacherImportExecutor extends AbstractImportExecutorImpl {

    public TeacherImportExecutor(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected void setEntityFields(StandardEntity entity, Node entityInformation) {
        //		<teacher tid="1296030" firstname="" middlename="" lastname=""/>

        Teacher teacher = (Teacher) entity;
        teacher.setIrTechId(Integer.valueOf(entityInformation.getAttributes().getNamedItem("tid").getNodeValue()));
        teacher.setTeacherName(entityInformation.getAttributes().getNamedItem("firstname").getNodeValue());
        teacher.setTeacherSecondName(entityInformation.getAttributes().getNamedItem("middlename").getNodeValue());
        teacher.setTeacherFamilyName(entityInformation.getAttributes().getNamedItem("lastname").getNodeValue());

    }
}
