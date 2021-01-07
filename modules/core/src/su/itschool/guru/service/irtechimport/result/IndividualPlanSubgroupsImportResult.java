package su.itschool.guru.service.irtechimport.result;

public class IndividualPlanSubgroupsImportResult extends AbstractImportResult {
    public IndividualPlanSubgroupsImportResult(int groupsCount) {
        result = "Импортирована информация о " + groupsCount + " подгруппах для индивидуального планирования";
    }
}
