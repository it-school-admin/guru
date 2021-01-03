package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;

import java.util.Map;
import java.util.Map.Entry;

//TODO test
public class LessonsGridImporter extends AbstractImporter{
    private final Map<Integer, LessonTimePojo> lessonTimes;
    private final LessonsGridType lessonsGridToImportTo;
    private final LessonsGridService lessonsGridService;

    public LessonsGridImporter(Map<Integer, LessonTimePojo> lessonTimes,
                               LessonsGridType lessonsGridToImportTo,
                               DataManager dataManager,
                               LessonsGridService lessonsGridService) {
        super(dataManager);
        this.lessonTimes = lessonTimes;
        this.lessonsGridToImportTo = lessonsGridToImportTo;
        this.lessonsGridService = lessonsGridService;
    }

    public void importDataToDb() {
        lessonsGridService.clearLessonsGrid(lessonsGridToImportTo);
        for (Entry<Integer, LessonTimePojo> lessonTimePojoEntry:lessonTimes.entrySet())
        {
            LessonTimePojo lessonTimePojo = lessonTimePojoEntry.getValue();

            LessonsGridItem lessonsGridItem = dataManager.create(LessonsGridItem.class);
            lessonsGridItem.setGridType(lessonsGridToImportTo);
            lessonsGridItem.setLessonNumber(lessonTimePojo.lessonNumber);
            lessonsGridItem.setLessonStartTime(lessonTimePojo.startTime);
            dataManager.commit(lessonsGridItem);
        }

    }
}
