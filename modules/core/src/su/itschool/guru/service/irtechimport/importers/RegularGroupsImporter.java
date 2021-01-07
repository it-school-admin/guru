package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RegularSubgroupPojo;
import su.itschool.guru.service.irtechimport.result.RegularGroupsImportResult;

import java.util.List;

public class RegularGroupsImporter extends AbstractImporter {
    private final List<RegularSubgroupPojo> regularSubGroups;
    private final IrTechImportFinderService irTechFinderService;

    public RegularGroupsImporter(List<RegularSubgroupPojo> regularSubGroups, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.regularSubGroups = regularSubGroups;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for (RegularSubgroupPojo subgroupPojo: regularSubGroups)
        {
            GroupForLesson subgroup = irTechFinderService.findSubGroupByIrTechIdAndClass(subgroupPojo.irTechId, subgroupPojo.classIrTechId);
            SchoolClass schoolClass = irTechFinderService.findClassByIrTechId(subgroupPojo.classIrTechId);
            if(subgroup == null)
            {
                subgroup = dataManager.create(GroupForLesson.class);
                subgroup.setIrTechId(subgroupPojo.irTechId);
            }
            subgroup.setSchoolClass(schoolClass);
            subgroup.setParentGroup(irTechFinderService.findRootClassGroup(subgroupPojo.classIrTechId));
            subgroup.setOwnName(subgroupPojo.name);
            subgroup.setCountStudent(subgroupPojo.studentsCount);
            dataManager.commit(subgroup);
        }
        return new RegularGroupsImportResult(regularSubGroups.size());
    }
}
