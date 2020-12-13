package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.entity.Teacher;
import su.itschool.guru.entity.TimeTableImport;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service(ImportIrTechXMLToDBService.NAME)
public class ImportIrTechXMLToDBServiceBean implements ImportIrTechXMLToDBService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<StandardEntity> parseIrTechXML(TimeTableImport timeTableImport) {

        System.out.println(timeTableImport.getImportedXMLData());
        List<StandardEntity> result = new ArrayList<>();
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            byte[] bytes = timeTableImport.getImportedXMLData().getBytes(StandardCharsets.UTF_8);
            Document importedXML = builder.parse(new ByteArrayInputStream(bytes));

            Element rootElement = importedXML.getDocumentElement();

            Node teachers = rootElement.getElementsByTagName("teachers").item(0);
            result.addAll(createTeachersEntities(teachers));

            Node subjects = rootElement.getElementsByTagName("subjects").item(0);
            result.addAll(createSubjectEntities(subjects));
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Collection<? extends StandardEntity> createSubjectEntities(Node subjects) {
        ArrayList<Subject> result = new ArrayList<>();
        NodeList subjectNodes = subjects.getChildNodes();
        for(int i = 0; i < subjectNodes.getLength(); i++) {
            Node item = subjectNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                result.add(createSubjectEntityByXML(subjectNodes.item(i)));
            }

        }
        return result;
    }

    private Subject createSubjectEntityByXML(Node item) {

        //		<subject sid="92764" name="Астрономия" abbr="Астр">
        Subject subject = dataManager.create(Subject.class);
        subject.setIrTechId(Integer.valueOf(item.getAttributes().getNamedItem("sid").getNodeValue()));
        subject.setSubjectName(item.getAttributes().getNamedItem("name").getNodeValue());
        subject.setShortenedName(item.getAttributes().getNamedItem("abbr").getNodeValue());
        dataManager.commit(subject);
        return subject;
    }

    private Collection<? extends StandardEntity> createTeachersEntities(Node teachers) {

        ArrayList<Teacher> result = new ArrayList<>();
        NodeList teacherNodes = teachers.getChildNodes();
        for(int i = 0; i < teacherNodes.getLength(); i++) {
            Node item = teacherNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                result.add(createTeacherEntityByXML(teacherNodes.item(i)));
            }

            }
        return result;
    }

    private Teacher createTeacherEntityByXML(Node item) {

        //		<teacher tid="1296030" firstname="" middlename="" lastname=""/>
        Teacher teacher = dataManager.create(Teacher.class);
        teacher.setIrTechId(Integer.valueOf(item.getAttributes().getNamedItem("tid").getNodeValue()));
        teacher.setTeacherName(item.getAttributes().getNamedItem("firstname").getNodeValue());
        teacher.setTeacherSecondName(item.getAttributes().getNamedItem("middlename").getNodeValue());
        teacher.setTeacherFamilyName(item.getAttributes().getNamedItem("lastname").getNodeValue());
        dataManager.commit(teacher);
        return teacher;
    }
}