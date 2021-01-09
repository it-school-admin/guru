package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RegularSubgroupPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.Collection;

public class RegularGroupsImporter extends AbstractImporter<GroupForLesson, RegularSubgroupPojo> {


    public RegularGroupsImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<RegularSubgroupPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.regularSubGroups;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирована информация о %0 подгруппах",
                String.valueOf(timeTablePojos.regularSubGroups.size()));
    }

    @Override
    protected void fillIrTechId(GroupForLesson instance, RegularSubgroupPojo pojo) {
        instance.setIrTechId(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(GroupForLesson instance, RegularSubgroupPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setSchoolClass(finderService.findClassByIrTechId(pojo.classIrTechId));
        instance.setParentGroup(finderService.findRootClassGroup(pojo.classIrTechId));
        instance.setOwnName(pojo.name);
        instance.setCountStudent(pojo.studentsCount);
    }

    @Override
    protected Class<GroupForLesson> getClassEntityClass() {
        return GroupForLesson.class;
    }

    @Override
    protected GroupForLesson findExistingInstance(RegularSubgroupPojo pojo) {
        return finderService.findSubGroupByIrTechIdAndClass(pojo.irTechId, pojo.classIrTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportClasses();
    }
}
