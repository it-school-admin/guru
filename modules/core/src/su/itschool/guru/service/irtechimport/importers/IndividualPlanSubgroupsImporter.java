package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForIndividualPlanning;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.IndividualPlanSubgroupPojo;
import su.itschool.guru.service.irtechimport.result.IndividualPlanSubgroupsImportResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IndividualPlanSubgroupsImporter extends AbstractImporter {
    private final Map<Integer, IndividualPlanSubgroupPojo> individualPlanSubgroupPojoMap;
    private final IrTechImportFinderService irTechFinderService;

    public IndividualPlanSubgroupsImporter(Map<Integer, IndividualPlanSubgroupPojo> individualPlanSubgroupPojoMap, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.individualPlanSubgroupPojoMap = individualPlanSubgroupPojoMap;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for (Map.Entry<Integer, IndividualPlanSubgroupPojo> subgroupPojoEntry: individualPlanSubgroupPojoMap.entrySet())
        {
            IndividualPlanSubgroupPojo subgroupPojo = subgroupPojoEntry.getValue();
            GroupForIndividualPlanning subgroup = irTechFinderService.findIndividualPlanSubgroupByPlanItemIrTechId(subgroupPojo.planItemIrTechId);
            if(subgroup == null)
            {
                subgroup = dataManager.create(GroupForIndividualPlanning.class);
                subgroup.setPlanItemIrTechId(subgroupPojo.planItemIrTechId);
                HashSet hashSet = new HashSet();
                hashSet.add(irTechFinderService.findClassByIrTechId(subgroupPojo.defaultSchoolClassIrTechId));
                subgroup.setLinkedClasses(hashSet);
            }
            subgroup.setName(subgroupPojo.name);
            subgroup.setStudentsCount(subgroupPojo.studentsCount);
            subgroup.setSubject(irTechFinderService.findSubjectByIrTechId(subgroupPojo.subject));
            dataManager.commit(subgroup);
        }
        return new IndividualPlanSubgroupsImportResult(individualPlanSubgroupPojoMap.size());
    }
}
