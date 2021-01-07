package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.IndividualPlanItemPojo;
import su.itschool.guru.service.irtechimport.result.IndividualPlanImportResult;

import java.util.List;

public class IndividualPlanImporter extends AbstractImporter {
    private final List<IndividualPlanItemPojo> individualPlanItems;
    private final IrTechImportFinderService irTechFinderService;

    public IndividualPlanImporter(List<IndividualPlanItemPojo> individualPlanItems, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.individualPlanItems = individualPlanItems;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for(IndividualPlanItemPojo planItemPojo: individualPlanItems)
        {
            LessonsPlanningItem planningItem = irTechFinderService.getPlanningItemByIrTechId(planItemPojo.irTechId);
            if(planningItem == null)
            {
                planningItem = dataManager.create(LessonsPlanningItem.class);
                planningItem.setIrTechID(planItemPojo.irTechId);
            }
            planningItem.setIsIndividualPlanItem(true);
            planningItem.setIndividualPlanGroup(irTechFinderService.findIndividualPlanSubgroupByPlanItemIrTechId(planItemPojo.irTechId));

            planningItem.setTeacher(irTechFinderService.findTeacherByIrTechId(planItemPojo.teacherId));
            planningItem.setHoursPerWeek(planItemPojo.hoursPerWeek);
            dataManager.commit(planningItem);
        }
        return new IndividualPlanImportResult(individualPlanItems.size());
    }
}
