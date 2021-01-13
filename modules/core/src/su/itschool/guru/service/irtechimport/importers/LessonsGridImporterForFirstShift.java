package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.Collection;

//TODO test
public class LessonsGridImporterForFirstShift extends AbstractLessonsGridImporter {


    public LessonsGridImporterForFirstShift(DataManager dataManager, IrTechImportFinderService finderService, LessonsGridService lessonsGridService) {
        super(dataManager, finderService, lessonsGridService);
    }

    @Override
    protected Collection<LessonTimePojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.firstShiftLessonsTimes;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирован %0 элемент в сетку уроков первой смены",
                String.valueOf(timeTablePojos.firstShiftLessonsTimes.size()));
    }

    @Override
    protected void executeBeforeImportActions(TimeTablePojos timeTablePojos, ImportSettings importSettings)
    {
        lessonsGridService.clearLessonsGrid(importSettings.getLessonsGridForFirstShift());
    }

    @Override
    protected void fillOrUpdateFields(LessonsGridItem instance, LessonTimePojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings, IrTechImportFinderService finderService) {
        instance.setGridType(importSettings.getLessonsGridForFirstShift());
        instance.setLessonNumber(pojo.lessonNumber);
        instance.setLessonStartTime(pojo.startTime);
    }


}
