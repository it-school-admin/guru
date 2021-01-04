package su.itschool.guru.service.irtechimport.result;

public class SubjectImportResult extends AbstractImportResult {

    public SubjectImportResult(Integer teachersCount) {
        result = "Ипортировано " + teachersCount + " записей о предметах";
    }
}
