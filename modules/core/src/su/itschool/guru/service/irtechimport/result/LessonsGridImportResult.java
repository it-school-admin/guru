package su.itschool.guru.service.irtechimport.result;

public class LessonsGridImportResult extends AbstractImportResult{

    public LessonsGridImportResult(Integer importedCount, String lessonsGridName) {
        result = "Импортировано " + importedCount + " элемент в сетку уроков \"" + lessonsGridName + "\"";
    }
}
