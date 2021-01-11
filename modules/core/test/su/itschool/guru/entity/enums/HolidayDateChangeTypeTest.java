package su.itschool.guru.entity.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolidayDateChangeTypeTest {

    @Test
    void testValues(){
        assertEquals(10, HolidayDateChangeType.WORKING_DAY.getId());
        assertEquals(20, HolidayDateChangeType.NOT_WORKING_DAY.getId());
        assertEquals(30, HolidayDateChangeType.SHORTENED_DAY.getId());
    }

    @Test
    void fromId() {
        assertEquals(HolidayDateChangeType.WORKING_DAY, HolidayDateChangeType.fromId(10));
        assertEquals(HolidayDateChangeType.NOT_WORKING_DAY, HolidayDateChangeType.fromId(20));
        assertEquals(HolidayDateChangeType.SHORTENED_DAY, HolidayDateChangeType.fromId(30));
    }

}