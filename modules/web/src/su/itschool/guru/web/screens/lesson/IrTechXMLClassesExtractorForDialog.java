package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import java.util.*;

//TODO the stub
public class IrTechXMLClassesExtractorForDialog {

    private FileUploadingAPI fileUploadingAPI;
    private List<SchoolClassWrapper> schoolClassesWrappersList = new ArrayList();

    public IrTechXMLClassesExtractorForDialog(FileUploadingAPI fileUploadingAPI) {

        this.fileUploadingAPI = fileUploadingAPI;
    }

    public List<SchoolClassWrapper> extractSchoolClassesData(File file) {
        try {
            return getClassesData(file);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private List<SchoolClassWrapper> getClassesData(File importingFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //TODO analize encoding
//        byte[] bytes = xmlDataAsString.getBytes(StandardCharsets.UTF_8);
         return extractClassesNodesFromRootElement(builder.parse(importingFile).getDocumentElement());

    }

    private List<SchoolClassWrapper> extractClassesNodesFromRootElement(Element documentElement) {
        Node planNode = documentElement.getElementsByTagName("Plan").item(0);
        List<Node> classesNodesList = new ArrayList<>();
        NodeList potentialClassesNodes = planNode.getChildNodes();
        for (int i = 0; i < potentialClassesNodes.getLength(); i++) {
            Node item = potentialClassesNodes.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                schoolClassesWrappersList.add(new SchoolClassWrapper(item));
//                classesNodesList.add(item);
            }
        }

        Collections.sort(schoolClassesWrappersList, new SchoolClassesComparator());

        return schoolClassesWrappersList;
    }

    //TODO ugly
    private String getStringAttributeValue(Node node, String fieldName) {
        return node.getAttributes().getNamedItem(fieldName).getNodeValue();
    }

    //TODO ugly
    private Integer getIntegerAttributeValue(Node node, String fieldName) {
        return Integer.valueOf(node.getAttributes().getNamedItem(fieldName).getNodeValue());
    }

    public class SchoolClassWrapper {
        private final Integer classId;
        private final String className;
        private final Integer grade;
        private final char letter;

        public SchoolClassWrapper(Node item) {
            classId = getIntegerAttributeValue(item, "id");
            className = getStringAttributeValue(item, "name");
            grade = getIntegerAttributeValue(item, "grade");
            letter = className.charAt(className.length()-1);
        }

        public Integer getClassId() {
            return classId;
        }

        public String getClassName() {
            return className;
        }
    }

    private class SchoolClassesComparator implements Comparator<SchoolClassWrapper> {

        @Override
        public int compare(SchoolClassWrapper o1, SchoolClassWrapper o2) {
            if(o1.grade>o2.grade) return 1;
            if ((o1.grade.equals(o2.grade)) && (o1.letter>o2.letter)) return 1;
            return -1;
        }
    }
}
