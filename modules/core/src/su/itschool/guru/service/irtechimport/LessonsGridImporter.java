package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;

import java.util.Map;

public class LessonsGridImporter {
    public LessonsGridImporter(Map<Integer, LessonTimePojo> firstShiftLessonsTimes,
                               Map<Integer, LessonTimePojo> secondShiftLessonsTimes,
                               LessonsGridType lessonsGridToImportTo, DataManager dataManager) {

    }

    public void importDataToDb() {

    }
}
