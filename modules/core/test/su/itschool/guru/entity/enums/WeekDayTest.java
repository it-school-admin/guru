package su.itschool.guru.entity.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayTest {
    @Test
    void testValues()
    {
        assertEquals(1, WeekDay.MONDAY.getId());
        assertEquals(2, WeekDay.TUESDAY.getId());
        assertEquals(3, WeekDay.WEDNESDAY.getId());
        assertEquals(4, WeekDay.THURSDAY.getId());
        assertEquals(5, WeekDay.FRIDAY.getId());
        assertEquals(6, WeekDay.SATURDAY.getId());
        assertEquals(7, WeekDay.SUNDAY.getId());
    }

    @Test
    void fromId() {
        assertEquals(WeekDay.MONDAY, WeekDay.fromId(1));
        assertEquals(WeekDay.TUESDAY, WeekDay.fromId(2));
        assertEquals(WeekDay.WEDNESDAY, WeekDay.fromId(3));
        assertEquals(WeekDay.THURSDAY, WeekDay.fromId(4));
        assertEquals(WeekDay.FRIDAY, WeekDay.fromId(5));
        assertEquals(WeekDay.SATURDAY, WeekDay.fromId(6));
        assertEquals(WeekDay.SUNDAY, WeekDay.fromId(7));
    }
}