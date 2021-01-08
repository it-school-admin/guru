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

import java.util.List;

public class LessonsGridImporterForSecondShift extends AbstractLessonsGridImporter{
    public LessonsGridImporterForSecondShift(DataManager dataManager, IrTechImportFinderService finderService, LessonsGridService lessonsGridService) {
        super(dataManager, finderService, lessonsGridService);
    }

    @Override
    protected List<LessonTimePojo> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.secondShiftLessonsTimes;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирован %0 элемент в сетку уроков второй смены",
                String.valueOf(timeTablePojos.secondShiftLessonsTimes.size()));
    }

    @Override
    protected void fillOrUpdateFields(LessonsGridItem instance, LessonTimePojo pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setGridType(importSettings.getLessonsGridForSecondShift());
        instance.setLessonNumber(pojo.lessonNumber);
        instance.setLessonStartTime(pojo.startTime);
    }
}
