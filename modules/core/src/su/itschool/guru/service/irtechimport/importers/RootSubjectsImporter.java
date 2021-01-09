package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RootSubjectPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.util.Collection;

import static su.itschool.guru.service.irtechimport.result.SomethingImportedResult.somethingImported;

public class RootSubjectsImporter extends AbstractImporter<Subject, RootSubjectPojo>{
    public RootSubjectsImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<RootSubjectPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.rootSubjects;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return somethingImported("Ипортировано %0 записей об обобщённых предметах",
                String.valueOf(timeTablePojos.rootSubjects.size()));
    }

    @Override
    protected void fillIrTechId(Subject instance, RootSubjectPojo pojo) {
        instance.setIrTechId(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(Subject instance, RootSubjectPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setSubjectName(pojo.name);
    }

    @Override
    protected Class<Subject> getClassEntityClass() {
        return Subject.class;
    }

    @Override
    protected Subject findExistingInstance(RootSubjectPojo pojo) {
        return finderService.findSubjectByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportSubjects();
    }
}
