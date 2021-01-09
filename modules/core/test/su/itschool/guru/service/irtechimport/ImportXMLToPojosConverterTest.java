package su.itschool.guru.service.irtechimport;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static su.itschool.guru.service.irtechimport.XMLSamples.*;

class ImportXMLToPojosConverterTest {

    @Test
    void importDataNotNull() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_LESSONS_TIMES);
        Assertions.assertNotNull(timeTablePojos);
    }

    @Test
    void importDataLessonsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_LESSONS_TIMES);
        Assertions.assertNotNull(timeTablePojos.firstShiftLessonsTimes);
        Assertions.assertNotNull(timeTablePojos.secondShiftLessonsTimes);
        Assertions.assertEquals(7,timeTablePojos.firstShiftLessonsTimes.size());
    }

    @Test
    void importDataTeachersImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_TEACHERS);
        Assertions.assertNotNull(timeTablePojos.teachers);
        Assertions.assertEquals(4,timeTablePojos.teachers.size());
    }

    @Test
    void importDataSubjectsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_SUBJECTS);
        Assertions.assertNotNull(timeTablePojos.subjects);
        Assertions.assertEquals(4, timeTablePojos.subjects.size());
    }

    @Test
    void importDataRoomsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_ROOMS);
        Assertions.assertNotNull(timeTablePojos.rooms);
        Assertions.assertEquals(7, timeTablePojos.rooms.size());
    }

    @Test
    void importDataClassesImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_PLAN);
        Assertions.assertNotNull(timeTablePojos.classes);
        Assertions.assertEquals(4,timeTablePojos.classes.size());
    }

    @Test
    void importDataRootGroupsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_PLAN);
        Assertions.assertNotNull(timeTablePojos.classes);
        Assertions.assertEquals(4,timeTablePojos.classes.size());
    }

    @Test
    void importDataRootSubjectsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_PLAN_WITH_ROOT_SUBJECTS);
        Assertions.assertNotNull(timeTablePojos.rootSubjects);
        Assertions.assertEquals(1,timeTablePojos.rootSubjects.size());
        Assertions.assertNotNull(timeTablePojos.rootSubjects.get(Integer.valueOf(FOREIGN_LANGUAGE_SUBJECT_ID)));
    }

    @Test
    void importDataSubgroupsImportedFor1_9Classes() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_1_9_CLASS_WITH_GROUPS);
        Assertions.assertNotNull(timeTablePojos.regularSubGroups);
        Assertions.assertEquals(6,timeTablePojos.regularSubGroups.size());
    }

    @Test
    void importDataSubgroupsImportedFor10_11Classes() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_10_11_CLASS_WITH_GROUPS);
        Assertions.assertNotNull(timeTablePojos.individualPlanSubgroups);
        Assertions.assertEquals(17,timeTablePojos.individualPlanSubgroups.size());
    }

    @Test
    void importDataPlanItemsImportedFor1_9Classes() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_1_9_CLASS_WITH_GROUPS);
        Assertions.assertNotNull(timeTablePojos.regularPlanItems);
        Assertions.assertEquals(16,timeTablePojos.regularPlanItems.size());
        Assertions.assertEquals(0,timeTablePojos.individualPlanItems.size());
    }

    @Test
    void importDataPlanItemsImportedFor10_11Classes() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_10_11_CLASS_WITH_GROUPS);
        Assertions.assertNotNull(timeTablePojos.regularPlanItems);
        Assertions.assertEquals(0,timeTablePojos.regularPlanItems.size());
        Assertions.assertEquals(17,timeTablePojos.individualPlanItems.size());
    }


    @Ignore
    void importLessons() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_LESSONS);
        Assertions.assertNotNull(timeTablePojos.lessons);
        Assertions.assertEquals(46,timeTablePojos.lessons.size());
    }

    private TimeTablePojos getTimeTablePojos(String text) {
        ImportXMLToPojosConverter importXMLToPojosConverter = new ImportXMLToPojosConverter();
        TimeTablePojos timeTablePojos = importXMLToPojosConverter.importData(getStream(text));
        return timeTablePojos;
    }

    private InputStream getStream(String text) {
        return new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    }
}