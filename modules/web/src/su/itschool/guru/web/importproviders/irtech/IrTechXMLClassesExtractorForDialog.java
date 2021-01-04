package su.itschool.guru.web.importproviders.irtech;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.io.IOException;

import java.util.*;

//TODO move to JDOM
public class IrTechXMLClassesExtractorForDialog {

    private List<SchoolClassWrapper> schoolClassesWrappersList = new ArrayList();

    public List<SchoolClassWrapper> extractSchoolClassesData(File importedFile) {
        try {
            return getClassesData(importedFile);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<SchoolClassWrapper> getClassesData(File importingFile) throws JDOMException, IOException
    {
        //TODO analize encoding
//        byte[] bytes = xmlDataAsString.getBytes(StandardCharsets.UTF_8);
        Element rootElement = new SAXBuilder().build(importingFile).getRootElement();
        return extractClassesNodesFromRootElement(rootElement);

    }

    private List<SchoolClassWrapper> extractClassesNodesFromRootElement(Element documentElement) {
        Element planElement = documentElement.getChild("Plan");
        List<Element> classesElements = planElement.getChildren();
        for (Element classElement: classesElements)
        {
                schoolClassesWrappersList.add(new SchoolClassWrapper(classElement));
        }

        Collections.sort(schoolClassesWrappersList, new SchoolClassesComparator());

        return schoolClassesWrappersList;
    }

}
