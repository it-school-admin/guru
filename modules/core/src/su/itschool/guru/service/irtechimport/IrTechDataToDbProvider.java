package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.io.InputStream;

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

    public void executeImport() {
        timeTablePojos = importXMLToPojosConverter.importData(getImportedFileAsStream());
        if (importSettings.getImportAdditionalData())
        {
            if(importSettings.getImportLessonsGrid())
            {
                importLessonGrids();
            }
        }
    }

    private void importLessonGrids() {
        new LessonsGridImporter(timeTablePojos.firstShiftLessonsTimes,
                importSettings.getLessonsGridForFirstShift(),
                dataManager,
                lessonsGridService)
        .importDataToDb();

        new LessonsGridImporter(timeTablePojos.secondShiftLessonsTimes,
                importSettings.getLessonsGridForSecondShift(),
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
