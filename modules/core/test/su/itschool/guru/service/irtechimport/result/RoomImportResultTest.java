package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class RoomImportResultTest {

    @Test
    void getResult()
    {
        ImportResult importResult = new RoomImportResult(20);
        assertEquals("Импортирована информация о 20 аудиториях" , importResult.getResultString());
    }
}