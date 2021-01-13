package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Teacher;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.TeacherPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.util.Collection;

import static su.itschool.guru.service.irtechimport.result.SomethingImportedResult.somethingImported;

public class TeacherImporter extends AbstractImporter<Teacher, TeacherPojo> {


    public TeacherImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<TeacherPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.teachers;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return somethingImported("Импортировано %0 записей об учителях",
                String.valueOf(timeTablePojos.teachers.size()));
    }

    @Override
    protected void fillIrTechId(Teacher instance, TeacherPojo pojo) {
        instance.setIrTechId(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(Teacher instance, TeacherPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings, IrTechImportFinderService finderService) {
        instance.setTeacherName(pojo.name);
        instance.setTeacherSecondName(pojo.middleName);
        instance.setTeacherFamilyName(pojo.lastName);
    }

    @Override
    protected Class<Teacher> getClassEntityClass() {
        return Teacher.class;
    }

    @Override
    protected Teacher findExistingInstance(TeacherPojo pojo) {
        return finderService.findTeacherByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportSubjects();
    }
}
