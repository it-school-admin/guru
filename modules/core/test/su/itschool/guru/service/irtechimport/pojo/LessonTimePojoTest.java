package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class LessonTimePojoTest extends AbstractPojoTest{
    private static final String LESSON_TIME_XML = "<LessonTime id=\"7\" starttime=\"8:00\" endtime=\"8:40\" sm=\"2\" number=\"1\" />";

    @Test
    void checkCreation()
    {
        LessonTimePojo lessonTimePojo = new LessonTimePojo(convertStringToElement(LESSON_TIME_XML));
        assertEquals(7, lessonTimePojo.irTechId);
        Assertions.assertEquals(LocalTime.of(8, 0), lessonTimePojo.startTime);
        Assertions.assertEquals(LocalTime.of(8, 40), lessonTimePojo.endTime);
        Assertions.assertEquals(1, lessonTimePojo.lessonNumber);
    }

}