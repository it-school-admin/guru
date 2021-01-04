package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.result.AbstractImportResult;

public class ClassesImportResult extends AbstractImportResult {
    public ClassesImportResult(Integer classesCount) {
        result = "Импортировано " + classesCount + " классов";
    }
}
