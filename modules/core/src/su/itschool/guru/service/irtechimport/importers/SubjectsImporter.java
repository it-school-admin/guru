package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.SubjectPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;


import java.util.ArrayList;
import java.util.List;

import static su.itschool.guru.service.irtechimport.result.SomethingImportedResult.somethingImported;

public class SubjectsImporter extends AbstractImporter<Subject, SubjectPojo> {

    public SubjectsImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected List<SubjectPojo> getPojos(TimeTablePojos timeTablePojos) {
        return new ArrayList(timeTablePojos.subjects.values());
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return somethingImported("Ипортировано %0 записей о предметах",
                String.valueOf(timeTablePojos.subjects.size()));
    }

    @Override
    protected void fillIrTechId(Subject instance, SubjectPojo pojo) {
        instance.setIrTechId(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(Subject instance, SubjectPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setSubjectName(pojo.name);
        instance.setShortenedName(pojo.abbr);
        Integer parentSubjectId = pojo.getParentSubject();
        if(parentSubjectId != null)
        {
            instance.setParentSubject(finderService.findSubjectByIrTechId(parentSubjectId));
        }
    }

    @Override
    protected Class<Subject> getClassEntityClass() {
        return Subject.class;
    }

    @Override
    protected Subject findExistingInstance(SubjectPojo pojo) {
        return finderService.findSubjectByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportSubjects();
    }
}
