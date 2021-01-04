package su.itschool.guru.service.irtechimport.result;


public class TeachersImportResult extends AbstractImportResult {
    public TeachersImportResult(Integer teachersCount) {
        result = "Импортировано " + teachersCount + " записей об учителях";
    }
}
