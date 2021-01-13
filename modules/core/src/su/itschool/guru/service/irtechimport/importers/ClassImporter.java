package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.SchoolClassPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.Collection;

public class ClassImporter extends AbstractImporter<SchoolClass, SchoolClassPojo> {


    public ClassImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<SchoolClassPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.classes;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортировано %0 классов",
                String.valueOf(timeTablePojos.classes.size()));
    }

    @Override
    protected void fillIrTechId(SchoolClass instance, SchoolClassPojo pojo) {
        instance.setIrTechId(pojo.irTechId);

    }

    @Override
    protected void fillOrUpdateFields(SchoolClass instance, SchoolClassPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings, IrTechImportFinderService finderService) {
        instance.setGrade(finderService.findGradeByNumber(pojo.grade));
        instance.setClassLetter(pojo.letter);
        instance.setStudentCount(pojo.countOfStudents);
    }

    @Override
    protected Class getClassEntityClass() {
        return SchoolClass.class;
    }

    @Override
    protected SchoolClass findExistingInstance(SchoolClassPojo pojo) {
        return finderService.findClassByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportClasses();
    }
}
