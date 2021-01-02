package su.itschool.guru.service.irtechimport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

class ImportXMLToPojosConverterTest {

    static private final String INPUT_DATA_LESSONS = "<TimeTableExchange xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"TimeTableWeek.xsd\">\n" +
            "\t<teachers/>\n" +
            "\t<LessonTimes>\n" +
            "\t\n" +
            "\t\t<LessonTime id=\"1\" starttime=\"8:00\" endtime=\"8:40\" sm=\"1\" number=\"1\" /> \n" +
            "\t\t<LessonTime id=\"2\" starttime=\"8:45\" endtime=\"9:25\" sm=\"1\" number=\"2\" /> \n" +
            "\t\t<LessonTime id=\"3\" starttime=\"9:35\" endtime=\"10:15\" sm=\"1\" number=\"3\" /> \n" +
            "\t\t<LessonTime id=\"4\" starttime=\"10:25\" endtime=\"11:05\" sm=\"1\" number=\"4\" /> \n" +
            "\t\t<LessonTime id=\"5\" starttime=\"11:25\" endtime=\"12:05\" sm=\"1\" number=\"5\" /> \n" +
            "\t\t<LessonTime id=\"6\" starttime=\"12:10\" endtime=\"12:50\" sm=\"1\" number=\"6\" /> \n" +
            "\t\t<LessonTime id=\"7\" starttime=\"13:20\" endtime=\"14:00\" sm=\"1\" number=\"7\" /> \n" +
            "\t\t<LessonTime id=\"8\" starttime=\"13:20\" endtime=\"14:00\" sm=\"2\" number=\"1\" /> \n" +
            "\t\t<LessonTime id=\"9\" starttime=\"14:10\" endtime=\"14:50\" sm=\"2\" number=\"2\" /> \n" +
            "\t\t<LessonTime id=\"10\" starttime=\"15:00\" endtime=\"15:40\" sm=\"2\" number=\"3\" /> \n" +
            "\t\t<LessonTime id=\"11\" starttime=\"15:50\" endtime=\"16:30\" sm=\"2\" number=\"4\" /> \n" +
            "\t\t<LessonTime id=\"12\" starttime=\"16:35\" endtime=\"17:15\" sm=\"2\" number=\"5\" /> \n" +
            "\t\t<LessonTime id=\"13\" starttime=\"17:20\" endtime=\"18:00\" sm=\"2\" number=\"6\" /> \n" +
            "\t</LessonTimes>\n" +
            "</TimeTableExchange>";

    static private final String INPUT_DATA_TEACHERS = "<TimeTableExchange>\n" +
            "\t<LessonTimes/>\n" +
            "\t<teachers>\n" +
            "\t\t<teacher tid=\"1296030\" firstname=\"Александров\" middlename=\"Павел\" lastname=\"Владимирович\"/>\n" +
            "\t\t<teacher tid=\"3543910\" firstname=\"Павлов\" middlename=\"Павел\" lastname=\"Павлович\"/>\n" +
            "\t\t<teacher tid=\"1333034\" firstname=\"Петров\" middlename=\"Пётр\" lastname=\"Петрович\"/>\n" +
            "\t\t<teacher tid=\"1337081\" firstname=\"Семёнова\" middlename=\"Анна\" lastname=\"Ивановна\"/>\n" +
            "\t</teachers>\n" +
            "</TimeTableExchange>";

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
        Assertions.assertTrue(timeTablePojos.firstShiftLessonsTimes.size() == 7);
    }

    @Test
    void importDataTeachersImported() {
        TimeTablePojos timeTablePojos = getTimeTablePojos(INPUT_DATA_TEACHERS);
        Assertions.assertNotNull(timeTablePojos.teachers);
        Assertions.assertTrue(timeTablePojos.teachers.size()==4);
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