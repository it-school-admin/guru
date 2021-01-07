package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class IndividualPlanSubgroupsImportResultTest {
    @Test
    void getResult()
    {
        ImportResult importResult = new IndividualPlanSubgroupsImportResult(5);
        assertEquals("Импортирована информация о 5 подгруппах для индивидуального планирования" , importResult.getResultString());
    }
}