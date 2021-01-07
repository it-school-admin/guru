package su.itschool.guru.service.irtechimport.result;

public class RegularPlanImportResult extends AbstractImportResult {
    public RegularPlanImportResult(Integer itemsCount) {
        result = "Импортирована информация о "+ itemsCount +" элементах плана";
    }
}
