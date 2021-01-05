package su.itschool.guru.service.irtechimport.result;

public class RegularGroupsImportResult extends AbstractImportResult {
    public RegularGroupsImportResult(Integer regularSubgroupsCount) {
        result = "Импортирована информация о " + regularSubgroupsCount + " подгруппах";
    }
}
