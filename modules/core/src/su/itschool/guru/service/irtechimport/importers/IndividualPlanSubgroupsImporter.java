package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForIndividualPlanning;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.IndividualPlanSubgroupPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.Collection;
import java.util.HashSet;

import static su.itschool.guru.service.irtechimport.importers.AbstractImporter.UpdateInstanceMode.NEW_INSTANCE;

public class IndividualPlanSubgroupsImporter extends AbstractImporter<GroupForIndividualPlanning, IndividualPlanSubgroupPojo> {

    public IndividualPlanSubgroupsImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<IndividualPlanSubgroupPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.individualPlanSubgroups;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирована информация о %0 подгруппах для индивидуального планирования",
                String.valueOf(timeTablePojos.individualPlanSubgroups.size()));
    }

    @Override
    protected void fillIrTechId(GroupForIndividualPlanning instance, IndividualPlanSubgroupPojo pojo) {
        instance.setPlanItemIrTechId(pojo.planItemIrTechId);
    }

    @Override
    protected void fillOrUpdateFields(GroupForIndividualPlanning instance, IndividualPlanSubgroupPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        if(updateMode == NEW_INSTANCE)
        {
            HashSet hashSet = new HashSet();
            hashSet.add(finderService.findClassByIrTechId(pojo.defaultSchoolClassIrTechId));
            instance.setLinkedClasses(hashSet);
        }
        instance.setName(pojo.name);
        instance.setStudentsCount(pojo.studentsCount);
        instance.setSubject(finderService.findSubjectByIrTechId(pojo.subject));
    }

    @Override
    protected Class<GroupForIndividualPlanning> getClassEntityClass() {
        return GroupForIndividualPlanning.class;
    }

    @Override
    protected GroupForIndividualPlanning findExistingInstance(IndividualPlanSubgroupPojo pojo) {
        return finderService.findIndividualPlanSubgroupByPlanItemIrTechId(pojo.planItemIrTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportStudyPlan();
    }
}
