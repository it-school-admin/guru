package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.AbstractPojoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LessonsGridImportResultTest extends AbstractPojoTest {

    @Test
    void getResult()
    {
        ImportResult lessonsGridImportResult = new LessonsGridImportResult(1, "Тестовая сетка");
        assertEquals("Импортировано 1 элемент в сетку уроков \"Тестовая сетка\"" , lessonsGridImportResult.getResultString());
    }


}