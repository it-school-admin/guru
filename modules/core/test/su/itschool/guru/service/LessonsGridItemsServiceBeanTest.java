package su.itschool.guru.service;

import org.junit.jupiter.api.Test;
import su.itschool.guru.entity.LessonsGridType;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LessonsGridItemsServiceBeanTest {

    @Test
    void timeCalculatorTest()
    {
        LessonsGridType gridTypeMock = mock(LessonsGridType.class);
        when(gridTypeMock.getDefaultLessonTime()).thenReturn(40);
        when(gridTypeMock.getDefaultPauseDuration()).thenReturn(10);
        when(gridTypeMock.getStartTime()).thenReturn(LocalTime.of(8,0));
        LessonsGridItemsServiceBean.LessonTimeCalculator lessonTimeCalculator = new LessonsGridItemsServiceBean.LessonTimeCalculator(gridTypeMock);

        assertEquals(LocalTime.of(8,0), lessonTimeCalculator.getStartTime(1));
        assertEquals(LocalTime.of(8,50), lessonTimeCalculator.getStartTime(2));
        assertEquals(LocalTime.of(9,40), lessonTimeCalculator.getStartTime(3));
        assertEquals(LocalTime.of(10,30), lessonTimeCalculator.getStartTime(4));
        assertEquals(LocalTime.of(11,20), lessonTimeCalculator.getStartTime(5));
        assertEquals(LocalTime.of(12,10), lessonTimeCalculator.getStartTime(6));
    }

}