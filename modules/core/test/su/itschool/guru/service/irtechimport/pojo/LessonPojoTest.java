package su.itschool.guru.service.irtechimport.pojo;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LessonPojoTest extends AbstractPojoTest {
    private static final String LESSON_WITHOUT_ROOM
            = "<csg id=\"5069664\"/>";

    private static final String LESSON_WITH_ROOM
            = "<csg id=\"4743527\" roomid=\"53207\"/>";

    public static final Integer DAY_OF_WEEK = Integer.valueOf(2);
    public static final Integer LESSON_NUMBER = Integer.valueOf(6);

    @Ignore
    void checkCreation_Lesson()
    {
        LessonPojo lessonPojo = new LessonPojo(
                convertStringToElement(LESSON_WITHOUT_ROOM),
                LESSON_NUMBER,
                DAY_OF_WEEK, new HashMap<Integer, RegularPlanItemPojo>(), new HashMap<Integer, IndividualPlanItemPojo>());
        assertEquals(5069664, lessonPojo.planItemId);
        assertEquals(DAY_OF_WEEK, lessonPojo.dayOfWeekNumber);
        assertEquals(LESSON_NUMBER, lessonPojo.lessonNumber);
        assertEquals(null, lessonPojo.roomId);
    }

    @Ignore
    void checkCreation_Lesson_with_room()
    {
        LessonPojo lessonPojo = new LessonPojo(
                convertStringToElement(LESSON_WITH_ROOM),
                LESSON_NUMBER,
                DAY_OF_WEEK, new HashMap<Integer, RegularPlanItemPojo>(), new HashMap<Integer, IndividualPlanItemPojo>());
        assertEquals(53207, lessonPojo.roomId);
    }

}