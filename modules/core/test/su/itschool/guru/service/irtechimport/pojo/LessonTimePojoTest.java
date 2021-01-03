package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class LessonTimePojoTest extends AbstractPojoTest{
    private static final String LESSON_TIME_XML = "<LessonTime id=\"1\" starttime=\"8:00\" endtime=\"8:40\" sm=\"1\" number=\"1\" />";

    @Test
    void checkCreation()
    {
        LessonTimePojo lessonTimePojo = new LessonTimePojo(convertStringToElement(LESSON_TIME_XML));
        assertEquals(lessonTimePojo.irTechId, 1);
        Assertions.assertEquals(lessonTimePojo.startTime, LocalTime.of(8, 0));
        Assertions.assertEquals(lessonTimePojo.endTime, LocalTime.of(8, 40));
    }

}