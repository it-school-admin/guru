package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RegularPlanItemPojo;
import su.itschool.guru.service.irtechimport.result.RegularPlanImportResult;

import java.util.Map;

public class RegularStudyPlanImporter extends AbstractImporter {
    private final Map<Integer, RegularPlanItemPojo> planItems;
    private final IrTechImportFinderService irTechFinderService;

    public RegularStudyPlanImporter(Map<Integer, RegularPlanItemPojo> planItems, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.planItems = planItems;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for (Map.Entry<Integer, RegularPlanItemPojo> planItemPojoEntry: planItems.entrySet())
        {
            RegularPlanItemPojo regularPlanItemPojo = planItemPojoEntry.getValue();
            LessonsPlanningItem planningItem = irTechFinderService.getPlanningItemByIrTechId(regularPlanItemPojo.irTechId);
            if(planningItem == null)
            {
                planningItem = dataManager.create(LessonsPlanningItem.class);
                planningItem.setIrTechID(regularPlanItemPojo.irTechId);
            }
            planningItem.setIsIndividualPlanItem(false);
            setRegularGroup(regularPlanItemPojo, planningItem);
            planningItem.setRegularSubject(irTechFinderService.findSubjectByIrTechId(regularPlanItemPojo.subjectId));
            planningItem.setTeacher(irTechFinderService.findTeacherByIrTechId(regularPlanItemPojo.teacherId));
            planningItem.setHoursPerWeek(regularPlanItemPojo.hoursPerWeek);
            dataManager.commit(planningItem);
        }
        return new RegularPlanImportResult(planItems.size());
    }

    private void setRegularGroup(RegularPlanItemPojo regularPlanItemPojo, LessonsPlanningItem planningItem) {
        GroupForLesson groupForLesson;
        if(regularPlanItemPojo.subGroupId == null)
        {
            groupForLesson = irTechFinderService.findRootClassGroup(regularPlanItemPojo.classIrTechId);
        }
        else
        {
            groupForLesson = irTechFinderService.findSubGroupByIrTechIdAndClass(regularPlanItemPojo.subGroupId, regularPlanItemPojo.classIrTechId);
        }

        planningItem.setRegularGroup(groupForLesson);
    }
}
