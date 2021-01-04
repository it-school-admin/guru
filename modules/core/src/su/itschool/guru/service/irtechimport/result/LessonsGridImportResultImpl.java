package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.ImportResult;

public class LessonsGridImportResultImpl implements ImportResult {


    private final String result;

    public LessonsGridImportResultImpl(Integer importedCount, String lessonsGridName) {
        result = "Импортировано " + importedCount + " элемент в сетку уроков \"" + lessonsGridName + "\"";
    }

    @Override
    public String getResultString() {
        return result;
    }
}
