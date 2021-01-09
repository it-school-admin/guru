package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.IndividualPlanItemPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.Collection;

public class IndividualPlanImporter extends AbstractImporter<LessonsPlanningItem, IndividualPlanItemPojo> {


    public IndividualPlanImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected Collection<IndividualPlanItemPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.individualPlanItems.values();
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирована информация о %0 элементах плана(индивидуальное планирование)",
                String.valueOf(timeTablePojos.individualPlanItems.size()));
    }

    @Override
    protected void fillIrTechId(LessonsPlanningItem instance, IndividualPlanItemPojo pojo) {
        instance.setIrTechID(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(LessonsPlanningItem instance, IndividualPlanItemPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setIsIndividualPlanItem(true);
        instance.setIndividualPlanGroup(finderService.findIndividualPlanSubgroupByPlanItemIrTechId(pojo.irTechId));

        instance.setTeacher(finderService.findTeacherByIrTechId(pojo.teacherId));
        instance.setHoursPerWeek(pojo.hoursPerWeek);

    }

    @Override
    protected Class<LessonsPlanningItem> getClassEntityClass() {
        return LessonsPlanningItem.class;
    }

    @Override
    protected LessonsPlanningItem findExistingInstance(IndividualPlanItemPojo pojo) {
        return finderService.getPlanningItemByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportStudyPlan();
    }
}
