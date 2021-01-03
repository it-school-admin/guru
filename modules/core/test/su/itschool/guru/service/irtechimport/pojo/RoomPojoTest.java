package su.itschool.guru.service.irtechimport.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomPojoTest extends AbstractPojoTest {
    private static final String ROOM_XML = "<room id=\"53207\" name=\"2 кабинет\" seats=\"30\" floor=\"1\"/>";

    @Test
    void checkCreation()
    {
        RoomPojo roomPojo = new RoomPojo(convertStringToElement(ROOM_XML));
        assertEquals(53207, roomPojo.irTechId);
        assertEquals("2 кабинет", roomPojo.name);
        assertEquals(30, roomPojo.seats);
        assertEquals(1, roomPojo.floor);
    }
}