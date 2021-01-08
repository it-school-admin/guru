package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.LessonsPlanningItem;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RegularPlanItemPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.List;

public class RegularStudyPlanImporter extends AbstractImporter<LessonsPlanningItem, RegularPlanItemPojo> {

    public RegularStudyPlanImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    private void setRegularGroup(RegularPlanItemPojo regularPlanItemPojo, LessonsPlanningItem planningItem) {
        GroupForLesson groupForLesson;
        if(regularPlanItemPojo.subGroupId == null)
        {
            groupForLesson = finderService.findRootClassGroup(regularPlanItemPojo.classIrTechId);
        }
        else
        {
            groupForLesson = finderService.findSubGroupByIrTechIdAndClass(regularPlanItemPojo.subGroupId, regularPlanItemPojo.classIrTechId);
        }

        planningItem.setRegularGroup(groupForLesson);
    }

    @Override
    protected List<RegularPlanItemPojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.regularPlanItems;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирована информация о %0 элементах плана",
                String.valueOf(timeTablePojos.regularPlanItems.size()));
    }

    @Override
    protected void fillIrTechId(LessonsPlanningItem instance, RegularPlanItemPojo pojo) {
        instance.setIrTechID(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(LessonsPlanningItem instance, RegularPlanItemPojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setIsIndividualPlanItem(false);
        setRegularGroup(pojo, instance);
        instance.setRegularSubject(finderService.findSubjectByIrTechId(pojo.subjectId));
        instance.setTeacher(finderService.findTeacherByIrTechId(pojo.teacherId));
        instance.setHoursPerWeek(pojo.hoursPerWeek);
    }

    @Override
    protected Class<LessonsPlanningItem> getClassEntityClass() {
        return LessonsPlanningItem.class;
    }

    @Override
    protected LessonsPlanningItem findExistingInstance(RegularPlanItemPojo pojo) {
        return finderService.getPlanningItemByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportStudyPlan();
    }
}
