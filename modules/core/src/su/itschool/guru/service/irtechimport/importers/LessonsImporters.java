package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.TimeTableTemplateItem;
import su.itschool.guru.entity.TimetableTemplate;
import su.itschool.guru.entity.enums.WeekDay;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.TimetableIrTechImportService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.LessonPojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.NothingImportedResult;

import java.util.Set;

import static su.itschool.guru.service.irtechimport.result.SomethingImportedResult.somethingImported;

public class LessonsImporters implements Importer {
    private final DataManager dataManager;
    private final IrTechImportFinderService finderService;
    private final TimetableIrTechImportService timetableIrTechImportService;

    public LessonsImporters(DataManager dataManager, IrTechImportFinderService finderService, TimetableIrTechImportService timetableIrTechImportService) {
        this.dataManager = dataManager;
        this.finderService = finderService;
        this.timetableIrTechImportService = timetableIrTechImportService;
    }
    @Override
    public ImportResult importDataToDb(TimeTablePojos timeTablePojos, ImportSettings importSettings) {
        if (importSettings.getImportTimetable())
        {
            Set<Integer> loadedClassesIrTechIds = importSettings.getSelectedClassesIds();
            TimetableTemplate timetableTemplate = importSettings.getTimetableTemplate();

            timetableIrTechImportService.clearTimeTableTemplate(timetableTemplate);

            int importedCount = 0;
            for (LessonPojo lessonPojo: timeTablePojos.lessons)
            {
                if(importSettings.getImportTimeTableForAllClasses())
                {
                    ImportTimetableTemplateItem(timetableTemplate, lessonPojo);
                    importedCount++;
                }
                else if(loadedClassesIrTechIds.contains(lessonPojo.irTechClassId))
                {
                    ImportTimetableTemplateItem(timetableTemplate, lessonPojo);
                    importedCount++;
                }
            }
            return somethingImported("Импортированы данные о %0 уроках", String.valueOf(importedCount));
        }
        else
        {
            return new NothingImportedResult();
        }
    }

    private void ImportTimetableTemplateItem(TimetableTemplate timetableTemplate, LessonPojo lessonPojo) {
        TimeTableTemplateItem timeTableTemplateItem = dataManager.create(TimeTableTemplateItem.class);
        timeTableTemplateItem.setTimetableTemplate(timetableTemplate);
        timeTableTemplateItem.setNumberOfLesson(lessonPojo.lessonNumber);
        timeTableTemplateItem.setWeekDay(WeekDay.fromId(lessonPojo.dayOfWeekNumber));
        if(lessonPojo.roomId != null)
        {
            timeTableTemplateItem.setRoom(finderService.getRoomByIrTechId(lessonPojo.roomId));
        }
        timeTableTemplateItem.setPlanningItem(finderService.getPlanningItemByIrTechId(lessonPojo.planItemId));
        dataManager.commit(timeTableTemplateItem);
    }
}
