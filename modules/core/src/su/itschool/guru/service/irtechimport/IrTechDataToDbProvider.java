package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.ImportFromIrtTechResultImpl;

import java.io.InputStream;
import java.util.Map;

public class IrTechDataToDbProvider {
    private final ImportSettings importSettings;
    private final DataManager dataManager;
    private ImportXMLToPojosConverter importXMLToPojosConverter;
    private final FileLoader fileLoader;
    private final LessonsGridService lessonsGridService;
    private TimeTablePojos timeTablePojos;

    public IrTechDataToDbProvider(ImportSettings importSettings,
                                  DataManager dataManager,
                                  ImportXMLToPojosConverter importXMLToPojosConverter,
                                  FileLoader fileLoader,
                                  LessonsGridService lessonsGridService) {
        this.importSettings = importSettings;
        this.dataManager = dataManager;
        this.importXMLToPojosConverter = importXMLToPojosConverter;
        this.fileLoader = fileLoader;
        this.lessonsGridService = lessonsGridService;
    }

    public ImportFromIrtTechResult executeImport() {
        ImportFromIrtTechResultImpl importResult = new ImportFromIrtTechResultImpl();
        timeTablePojos = importXMLToPojosConverter.importData(getImportedFileAsStream());
        if (importSettings.getImportAdditionalData())
        {
            if(importSettings.getImportLessonsGrid())
            {
                importResult.addResult(importLessonGrid(timeTablePojos.firstShiftLessonsTimes, importSettings.getLessonsGridForFirstShift()));
                importResult.addResult(importLessonGrid(timeTablePojos.secondShiftLessonsTimes, importSettings.getLessonsGridForSecondShift()));
            }
        }

        return importResult;
    }

    private ImportResult importLessonGrid(Map<Integer, LessonTimePojo> lessonTimePojos, LessonsGridType lessonsGrid) {
        return new LessonsGridImporter(lessonTimePojos,
                lessonsGrid,
                dataManager,
                lessonsGridService)
                .importDataToDb();
    }

    private InputStream getImportedFileAsStream() {
        try {
            return fileLoader.openStream(importSettings.getImportedFileDescriptor());
        } catch (FileStorageException e) {
            throw  new RuntimeException(e);
        }
    }
}
