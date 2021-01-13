package su.itschool.guru.listeners;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import su.itschool.guru.entity.LessonsGridType;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LessonsGridTypeChangedListenerTest {

    @Test
    void timeCalculatorTest()
    {
        LessonsGridType gridTypeMock = mock(LessonsGridType.class);
        when(gridTypeMock.getDefaultLessonTime()).thenReturn(40);
        when(gridTypeMock.getDefaultPauseDuration()).thenReturn(10);
        when(gridTypeMock.getStartTime()).thenReturn(LocalTime.of(8,0));
        LessonsGridTypeChangedListener.LessonTimeCalculator lessonTimeCalculator = new LessonsGridTypeChangedListener.LessonTimeCalculator(gridTypeMock);

        assertEquals(LocalTime.of(8,0), lessonTimeCalculator.getStartTime(1));
        assertEquals(LocalTime.of(8,50), lessonTimeCalculator.getStartTime(2));
        assertEquals(LocalTime.of(9,40), lessonTimeCalculator.getStartTime(3));
        assertEquals(LocalTime.of(10,30), lessonTimeCalculator.getStartTime(4));
        assertEquals(LocalTime.of(11,20), lessonTimeCalculator.getStartTime(5));
        assertEquals(LocalTime.of(12,10), lessonTimeCalculator.getStartTime(6));
    }

}