package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import org.springframework.stereotype.Service;
import su.itschool.guru.service.irtechimport.ImportXMLToPojosConverter;
import su.itschool.guru.service.irtechimport.IrTechDataToDbProvider;

import javax.inject.Inject;


//TODO very bad code. Rewrite all!!!
@Service(ImportIrTechXMLToDBService.NAME)
public class ImportIrTechXMLToDBServiceBean implements ImportIrTechXMLToDBService {
    @Inject
    private DataManager dataManager;
    @Inject
    private IrTechImportFinderService finderService;
    @Inject
    private FileLoader fileLoader;
    @Inject
    private LessonsGridService lessonsGridService;

/*    @Override
    public List<StandardEntity> parseIrTechXML(TimeTableImport timeTableImport, LessonsGridType lessonsGridType) {

        List<StandardEntity> result = new ArrayList<>();
        try {
            Element rootElement = getDocumentElementByXMLText(timeTableImport.getImportedXMLData());

          //  addLessonsGridItems(result, rootElement, lessonsGridType);
            Map<Integer, Integer> lessonIDtoNumberMap =  fillLessonsIDsMap(rootElement);

            addSubjects(result, rootElement);
            addTeachers(result, rootElement);
            addRooms(result, rootElement);
            addClassesAndGroupsAndPlanningItems(result, rootElement);
            addLessonsToTimeTableTemplate(result, rootElement, lessonIDtoNumberMap);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/

    @Override
    public void importData(ImportSettings importSettings) {
        IrTechDataToDbProvider irTechDataToDbProvider = new IrTechDataToDbProvider(
                importSettings,
                dataManager,
                new ImportXMLToPojosConverter(),
                fileLoader,
                lessonsGridService);
        irTechDataToDbProvider.executeImport();
    }

 /*   private Map<Integer, Integer> fillLessonsIDsMap(Element rootElement) {

        Map<Integer, Integer> lessonIDtoNumberMap = new HashMap<Integer, Integer>();
        Node rootElementCollectionNode = getFirstChildNodeByName(rootElement, "LessonTimes");

        NodeList childNodes = rootElementCollectionNode.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                lessonIDtoNumberMap.put(
                        Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue()),
                        Integer.parseInt(item.getAttributes().getNamedItem("number").getNodeValue())
                );
            }

        }

        return lessonIDtoNumberMap;

    }

    private void addLessonsToTimeTableTemplate(List<StandardEntity> result, Element rootElement, Map<Integer, Integer> lessonIDtoNumberMap) {
        Node timeTableNode = getFirstChildNodeByName(rootElement, "TimeTable");
        Node weekNode = getFirstChildNodeByName(timeTableNode, "Week");
        if(weekNode.getNodeType() != Node.ELEMENT_NODE)
        {
            //TODO hardcode!!!!!!
            weekNode = timeTableNode.getChildNodes().item(1);
        }
        NodeList dayNodes = weekNode.getChildNodes();


        for(int i = 0; i < dayNodes.getLength(); i++) {
            Node dayNode = dayNodes.item(i);
            if(dayNode.getNodeType()==Node.ELEMENT_NODE){
                Integer day = Integer.valueOf(dayNode.getAttributes().getNamedItem("id").getNodeValue());
                NodeList lessonNoNodes = dayNode.getChildNodes();
                for(int j = 0; j < lessonNoNodes.getLength(); j++) {
                    Node lessonNoNode = lessonNoNodes.item(j);
                    if(lessonNoNode.getNodeType()==Node.ELEMENT_NODE){
                        Integer lessonTimeId = Integer.valueOf(lessonNoNode.getAttributes().getNamedItem("timeId").getNodeValue());
                        Integer lessonNumber = lessonIDtoNumberMap.get(lessonTimeId);

                        TimeTableItemImportExecutor timeTableItemImportExecutor = new TimeTableItemImportExecutor(TimeTableTemplateItem.class, finderService, dataManager, day, lessonNumber);


                        NodeList lessonNodes = lessonNoNode.getChildNodes();
                        for(int k = 0; k < lessonNodes.getLength(); k++) {
                            Node lessonNode = lessonNodes.item(k);
                            if(lessonNode.getNodeType()==Node.ELEMENT_NODE){
                                result.add(timeTableItemImportExecutor.execute(null, null, lessonNode));
                            }


                        }

                    }

                }

            }

        }


    }

    private void addLessonsGridItems(List<StandardEntity> result, Element rootElement, LessonsGridType lessonsGridType) {
        result.addAll(createChildEntities(rootElement, "LessonTimes", new LessonsGridItemsImportExecutor(LessonsGridItem.class, finderService, dataManager, lessonsGridType)));

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
        MainGroupsForLessonsExecutor mainGroupsForLessonsExecutor = new MainGroupsForLessonsExecutor(
                GroupForLesson.class,
                finderService,
                dataManager);
        SubGroupsForLessonsExecutor subGroupsForLessonsExecutor = new SubGroupsForLessonsExecutor(
                GroupForLesson.class,
                finderService,
                dataManager);

        for(int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                Node currentNode = childNodes.item(i);
                StandardEntity createdSchoolClass = schoolClassImportExecutor.execute(null, null, currentNode);
                result.add(createdSchoolClass);
                result.addAll(createChildEntities(currentNode, createdSchoolClass, mainGroupsForLessonsExecutor));
                result.addAll(createChildEntities(currentNode, createdSchoolClass, subGroupsForLessonsExecutor));
                result.addAll(createChildEntities(currentNode, createdSchoolClass, lessonPlanningItemImportExecutor));
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
                if(entityImportExecutor.needToBeCreated(item))
                result.add(entityImportExecutor.execute(rootElementCollectionNode, rootEntity, item));
            }

        }
        return result;
    }

    private Node getFirstChildNodeByName(Element rootElement, String nodeName) {
        return rootElement.getElementsByTagName(nodeName).item(0);
    }

    private Node getFirstChildNodeByName(Node rootNode, String nodeName) {
        return rootNode.getChildNodes().item(0);
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
    }*/

}