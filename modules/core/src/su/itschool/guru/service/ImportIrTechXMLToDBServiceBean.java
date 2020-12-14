package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import su.itschool.guru.entity.*;
import su.itschool.guru.service.entityImortExecutors.*;

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

//TODO very bad code. Rewrite all!!!
@Service(ImportIrTechXMLToDBService.NAME)
public class ImportIrTechXMLToDBServiceBean implements ImportIrTechXMLToDBService {

    @Inject
    private DataManager dataManager;
    @Inject
    private EntitiesByIrTechIdFinderService finderService;

    @Override
    public List<StandardEntity> parseIrTechXML(TimeTableImport timeTableImport) {

        List<StandardEntity> result = new ArrayList<>();
        try {
            Element rootElement = getDocumentElementByXMLText(timeTableImport.getImportedXMLData());

            addSubjects(result, rootElement);
            addTeachers(result, rootElement);
            addRooms(result, rootElement);
            addClassesAndGroupsAndPlanningItems(result, rootElement);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void addClassesAndGroupsAndPlanningItems(List<StandardEntity> result, Element rootElement) {
        result.addAll(parsePlanningItems(rootElement));
    }

    private void addRooms(List<StandardEntity> result, Element rootElement) {
        result.addAll(createChildEntities(rootElement, "Rooms", new RoomImportExecutor(Room.class, finderService, dataManager)));

    }

    private void addTeachers(List<StandardEntity> result, Element rootElement) {
        result.addAll(createChildEntities(rootElement, "subjects", new SubjectImportExecutor(Subject.class, finderService, dataManager)));
    }

    private void addSubjects(List<StandardEntity> result, Element rootElement) {
        result.addAll(createChildEntities(rootElement, "teachers", new TeacherImportExecutor(Teacher.class, finderService, dataManager)));
    }

    //TODO move to a separate class
    private Collection<? extends StandardEntity> createChildEntities(Element rootElement, String elementName, EntityImportExecutor entityImportExecutor) {
        Node rootElementCollectionNode = getFirstChildNodeByName(rootElement, elementName);
        return createChildEntities(rootElementCollectionNode, null, entityImportExecutor);
    }

    private Collection<? extends StandardEntity> parsePlanningItems(Element documentRoot) {
        ArrayList<StandardEntity> result = new ArrayList<>();

        NodeList childNodes = getFirstChildNodeByName(documentRoot, "Plan").getChildNodes();

        SchoolClassImportExecutor schoolClassImportExecutor = new SchoolClassImportExecutor(SchoolClass.class, finderService, dataManager);
        LessonPlanningItemImportExecutor lessonPlanningItemImportExecutor = new LessonPlanningItemImportExecutor(LessonsPlanningItem.class, finderService, dataManager);
        MainGroupsForLessonsExecutor mainGroupsForLessonsExecutor = new MainGroupsForLessonsExecutor(GroupForLesson.class, finderService, dataManager);
        SubGroupsForLessonsExecutor subGroupsForLessonsExecutor = new SubGroupsForLessonsExecutor(GroupForLesson.class, finderService, dataManager);

        for(int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                Node currentNode = childNodes.item(i);
                //TODO
                StandardEntity createdClass = schoolClassImportExecutor.execute(null, null, currentNode);
                result.add(createdClass);
                result.addAll(createChildEntities(currentNode, createdClass, mainGroupsForLessonsExecutor));
                //result.addAll(createChildEntities(currentNode, subGroupsForLessonsExecutor));
            // TODO   result.addAll(createChildEntities(currentNode, lessonPlanningItemImportExecutor, dataManager));
            }

        }
        return result;
    }


    private Collection<? extends StandardEntity> createChildEntities(Node rootElementCollectionNode, StandardEntity rootEntity, EntityImportExecutor entityImportExecutor) {
        ArrayList<StandardEntity> result = new ArrayList<>();
        NodeList childNodes = rootElementCollectionNode.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                result.add(entityImportExecutor.execute(rootElementCollectionNode, rootEntity, childNodes.item(i)));
            }

        }
        return result;
    }

    private Node getFirstChildNodeByName(Element rootElement, String nodeName) {
        return rootElement.getElementsByTagName(nodeName).item(0);
    }

    private Element getDocumentElementByXMLText(String xmlDataAsString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //TODO analize encoding
        byte[] bytes = xmlDataAsString.getBytes(StandardCharsets.UTF_8);
        Document importedXML = builder.parse(new ByteArrayInputStream(bytes));

        Element rootElement = importedXML.getDocumentElement();
        return rootElement;
    }

}