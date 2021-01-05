package su.itschool.guru.service.irtechimport;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import su.itschool.guru.service.irtechimport.pojo.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImportXMLToPojosConverter {
    public TimeTablePojos importData(InputStream inputStream) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            TimeTablePojos timeTablePojos = new TimeTablePojos();
            Document xmlDocument = saxBuilder.build(inputStream);
            Element rootElement = xmlDocument.getRootElement();
            fillLessonTimesPojos(rootElement, timeTablePojos);
            fillTeachersPojos(rootElement, timeTablePojos);
            fillSubjectsPojos(rootElement, timeTablePojos);
            fillRoomsPojos(rootElement, timeTablePojos);
            fillClassesPojosAndAllInnerContent(rootElement, timeTablePojos);
            fillLessonsPojos(rootElement, timeTablePojos);

            return timeTablePojos;
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillLessonsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> dayElements = rootElement.getChild("TimeTable").getChild("Week").getChildren("Day");
        for(Element dayElement: dayElements)
        {
            Integer dayId = Integer.valueOf(dayElement.getAttributeValue("id"));
            for (Element lessonNumberElement: dayElement.getChildren("Lesson"))
            {
                Integer lessonNumber = Integer.valueOf(lessonNumberElement.getAttributeValue("timeId"));
                for(Element lessonElement: lessonNumberElement.getChildren("csg"))
                {
                    timeTablePojos.lessons.add(new LessonPojo(lessonElement, lessonNumber, dayId));
                }
            }
        }

    }

    private void fillClassesPojosAndAllInnerContent(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> classElements = rootElement.getChild("Plan").getChildren("class");
        for (Element classElement: classElements)
        {
            SchoolClassPojo schoolClassPojo = new SchoolClassPojo(classElement);
            timeTablePojos.classes.put(schoolClassPojo.irTechId, schoolClassPojo);
            for(Element planItemElement: classElement.getChildren("csg"))
            {
                if (containsParentSubjectInformation(planItemElement))
                {
                    createRootSubject(timeTablePojos, planItemElement);
                }

                if(schoolClassPojo.grade<10)
                {
                    if(!planItemElement.getAttributeValue("groupid").isEmpty())
                    {
                        createRegularSubgroup(timeTablePojos, schoolClassPojo, planItemElement);
                    }

                }
                else
                {
                    createIndividualPlanSubgroup(timeTablePojos, schoolClassPojo, planItemElement);
                }

                createPlanItem(timeTablePojos, schoolClassPojo, planItemElement);

            }
        }
    }

    private void createPlanItem(TimeTablePojos timeTablePojos, SchoolClassPojo schoolClassPojo, Element planItemElement) {
        PlanItemPojo planItemPojo = new PlanItemPojo(planItemElement, schoolClassPojo.irTechId);
        timeTablePojos.planItems.put(planItemPojo.irTechId, planItemPojo);
    }

    private void createIndividualPlanSubgroup(TimeTablePojos timeTablePojos, SchoolClassPojo schoolClassPojo, Element planItemElement) {
        IndividualPlanSubgroupPojo individualPlanSubgroupPojo = new IndividualPlanSubgroupPojo(planItemElement, schoolClassPojo.irTechId);
        timeTablePojos.planItemIdsWithIndividualPlanSubgroups.put(individualPlanSubgroupPojo.planItemIrTechId, individualPlanSubgroupPojo);
    }

    private void createRegularSubgroup(TimeTablePojos timeTablePojos, SchoolClassPojo schoolClassPojo, Element planItemElement) {
        RegularSubgroupPojo regularSubgroupPojo = new RegularSubgroupPojo(planItemElement, schoolClassPojo.irTechId);
        timeTablePojos.regularSubGroups.add(regularSubgroupPojo);
    }

    private void createRootSubject(TimeTablePojos timeTablePojos, Element planItemElement) {
        RootSubjectPojo rootSubjectPojo = new RootSubjectPojo(planItemElement);
        timeTablePojos.rootSubjects.put(rootSubjectPojo.irTechId, rootSubjectPojo);
        updateChildSubject(timeTablePojos, rootSubjectPojo, planItemElement);
    }

    private void updateChildSubject(TimeTablePojos timeTablePojos, RootSubjectPojo rootSubjectPojo, Element planItemElement) {
        Integer subjectId = Integer.valueOf(planItemElement.getAttributeValue("sid"));
        timeTablePojos.subjects.get(subjectId).setParentSubject(rootSubjectPojo.irTechId);
    }

    private boolean containsParentSubjectInformation(Element planItemElement) {
        String parentSubjectId = planItemElement.getAttributeValue("parentsubjectid");
        return (!parentSubjectId.isEmpty())
                && (!parentSubjectId.equals("1"));
    }

    private void fillRoomsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> roomElements = rootElement.getChild("Rooms").getChildren("room");
        for (Element roomElement: roomElements)
        {
            RoomPojo roomPojo = new RoomPojo(roomElement);
            timeTablePojos.rooms.put(roomPojo.irTechId, roomPojo);
        }

    }

    private void fillSubjectsPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> subjectElements = rootElement.getChild("subjects").getChildren("subject");
        for (Element subjectElement: subjectElements)
        {
            SubjectPojo subjectPojo = new SubjectPojo(subjectElement);
            timeTablePojos.subjects.put(subjectPojo.irTechId, subjectPojo);
        }
    }

    private void fillTeachersPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> teacherElements = rootElement.getChild("teachers").getChildren("teacher");
        for (Element teacherElement: teacherElements)
        {
            TeacherPojo teacherPojo = new TeacherPojo(teacherElement);
            timeTablePojos.teachers.put(teacherPojo.irTechId, teacherPojo);
        }

    }

    private void fillLessonTimesPojos(Element rootElement, TimeTablePojos timeTablePojos) {
        List<Element> lessonTimeElements = rootElement.getChild("LessonTimes").getChildren("LessonTime");
        for (Element lessonTimeElement: lessonTimeElements)
        {
            byte shift = Byte.valueOf(lessonTimeElement.getAttributeValue("sm"));
            LessonTimePojo lessonTimePojo = new LessonTimePojo(lessonTimeElement);
            if(shift == 1)
            {
                timeTablePojos.firstShiftLessonsTimes.put(lessonTimePojo.irTechId, lessonTimePojo);
            }
            else
            {
                timeTablePojos.secondShiftLessonsTimes.put(lessonTimePojo.irTechId, lessonTimePojo);
            }
        }

    }
}
