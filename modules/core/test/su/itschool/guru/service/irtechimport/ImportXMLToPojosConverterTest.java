package su.itschool.guru.service.irtechimport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static su.itschool.guru.service.irtechimport.XMLSamples.*;

class ImportXMLToPojosConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void importDataNotNull() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_LESSONS);
        Assertions.assertNotNull(timeTablePojos);
    }

    @Test
    void importDataLessonsImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_LESSONS);
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


    private TimeTablePojos getTimeTablePojos(String text) {
        ImportXMLToPojosConverter importXMLToPojosConverter = new ImportXMLToPojosConverter();
        TimeTablePojos timeTablePojos = importXMLToPojosConverter.importData(getStream(text));
        return timeTablePojos;
    }

    private InputStream getStream(String text) {
        return new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    }
}