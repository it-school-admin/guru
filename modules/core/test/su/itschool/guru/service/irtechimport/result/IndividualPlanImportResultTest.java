package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class IndividualPlanImportResultTest {
    @Test
    void getResult()
    {
        ImportResult importResult = new IndividualPlanImportResult(200);
        assertEquals("Импортирована информация о 200 элементах плана(индивидуальное планирование)" , importResult.getResultString());
    }
}