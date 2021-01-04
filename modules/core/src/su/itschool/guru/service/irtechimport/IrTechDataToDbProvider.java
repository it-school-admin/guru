package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.importers.LessonsGridImporter;
import su.itschool.guru.service.irtechimport.importers.RoomImporter;
import su.itschool.guru.service.irtechimport.importers.SubjectImporter;
import su.itschool.guru.service.irtechimport.importers.TeacherImporter;
import su.itschool.guru.service.irtechimport.pojo.*;
import su.itschool.guru.service.irtechimport.result.ImportFromIrtTechResultImpl;

import java.io.InputStream;
import java.util.Map;

public class IrTechDataToDbProvider {
    private final ImportSettings importSettings;
    private final DataManager dataManager;
    private ImportXMLToPojosConverter importXMLToPojosConverter;
    private final FileLoader fileLoader;
    private final LessonsGridService lessonsGridService;
    private final IrTechImportFinderService irTechFinderService;
    private TimeTablePojos timeTablePojos;

    public IrTechDataToDbProvider(ImportSettings importSettings,
                                  DataManager dataManager,
                                  ImportXMLToPojosConverter importXMLToPojosConverter,
                                  FileLoader fileLoader,
                                  LessonsGridService lessonsGridService,
                                  IrTechImportFinderService irTechFinderService) {
        this.importSettings = importSettings;
        this.dataManager = dataManager;
        this.importXMLToPojosConverter = importXMLToPojosConverter;
        this.fileLoader = fileLoader;
        this.lessonsGridService = lessonsGridService;
        this.irTechFinderService = irTechFinderService;
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

            if(importSettings.getImportTeachers())
            {
                importResult.addResult(importTeachers(timeTablePojos.teachers));
            }


            if(importSettings.getImportSubjects())
            {
                importResult.addResult(importSubjects(timeTablePojos.subjects, timeTablePojos.rootSubjects));
            }

            if(importSettings.getImportRooms())
            {
                importResult.addResult(importRooms(timeTablePojos.rooms));
            }
        }

        return importResult;
    }

    private ImportResult importRooms(Map<Integer, RoomPojo> rooms) {
        return new RoomImporter(rooms, dataManager, irTechFinderService).importDataToDb();
    }

    private ImportResult importTeachers(Map<Integer, TeacherPojo> teachers) {
        return new TeacherImporter(teachers, dataManager, irTechFinderService).importDataToDb();
    }

    private ImportResult importSubjects(Map<Integer, SubjectPojo> subjectPojos, Map<Integer, RootSubjectPojo> rootSubjects) {
        return new SubjectImporter(subjectPojos, rootSubjects, dataManager, irTechFinderService).importDataToDb();
    }

    private ImportResult importLessonGrid(Map<Integer, LessonTimePojo> lessonTimePojos, LessonsGridType lessonsGridForFirstShift) {
        return new LessonsGridImporter(lessonTimePojos,
                lessonsGridForFirstShift,
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
