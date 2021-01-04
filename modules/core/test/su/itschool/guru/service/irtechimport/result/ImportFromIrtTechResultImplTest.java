package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.AbstractPojoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ImportFromIrtTechResultImplTest extends AbstractPojoTest {

    @Test
    void LessonsGridImportResultTest_noLines()
    {
        ImportFromIrtTechResultImpl importFromIrtTechResult = new ImportFromIrtTechResultImpl();
        assertEquals("Ничего не импортировано", importFromIrtTechResult.getResultText());
    }


    @Test
    void LessonsGridImportResultTest_onlyOneLine()
    {
        ImportFromIrtTechResultImpl importFromIrtTechResult = new ImportFromIrtTechResultImpl();
        importFromIrtTechResult.addResult(createMockedResult("Первая строка"));
        assertEquals("Первая строка", importFromIrtTechResult.getResultText());
    }

    @Test
    void LessonsGridImportResultTest_twoLines()
    {
        ImportFromIrtTechResultImpl importFromIrtTechResult = new ImportFromIrtTechResultImpl();
        importFromIrtTechResult.addResult(createMockedResult("Первая строка"));
        importFromIrtTechResult.addResult(createMockedResult("Вторая строка"));
        assertEquals("Первая строка\nВторая строка", importFromIrtTechResult.getResultText());
    }

    @Test
    void LessonsGridImportResultTest_threeLines()
    {
        ImportFromIrtTechResultImpl importFromIrtTechResult = new ImportFromIrtTechResultImpl();
        importFromIrtTechResult.addResult(createMockedResult("Первая строка"));
        importFromIrtTechResult.addResult(createMockedResult("Вторая строка"));
        importFromIrtTechResult.addResult(createMockedResult("Третья строка"));
        assertEquals("Первая строка\nВторая строка\nТретья строка", importFromIrtTechResult.getResultText());
    }

    private ImportResult createMockedResult(String result) {
        ImportResult mock = mock(ImportResult.class);
        when(mock.getResultString()).thenReturn(result);
        return mock;
    }
}