package su.itschool.guru.service.irtechimport.result;

public class IndividualPlanImportResult extends AbstractImportResult {
    public IndividualPlanImportResult(Integer planItemsCount) {
        result = "Импортирована информация о " + planItemsCount + " элементах плана(индивидуальное планирование)";
    }
}
