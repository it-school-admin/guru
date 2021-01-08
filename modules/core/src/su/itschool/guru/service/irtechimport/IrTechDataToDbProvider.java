package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.importers.*;
import su.itschool.guru.service.irtechimport.pojo.*;
import su.itschool.guru.service.irtechimport.result.ImportFromIrtTechResultImpl;

import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;

public class IrTechDataToDbProvider {
    private final ImportSettings importSettings;
    private final DataManager dataManager;
    private ImportXMLToPojosConverter importXMLToPojosConverter;
    private final FileLoader fileLoader;
    private final LessonsGridService lessonsGridService;
    private final IrTechImportFinderService irTechFinderService;
    private final List<Importer> importers;
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

        importers = createImporters();
    }

    private List<Importer> createImporters() {
        return asList(
                new LessonsGridImporterForFirstShift(dataManager, irTechFinderService, lessonsGridService),
                new LessonsGridImporterForFirstShift(dataManager, irTechFinderService, lessonsGridService),
                new RoomImporter(dataManager, irTechFinderService),
                new RootSubjectsImporter(dataManager, irTechFinderService),
                new TeacherImporter(dataManager, irTechFinderService),
                new SubjectsImporter(dataManager, irTechFinderService),
                new ClassImporter(dataManager, irTechFinderService),
                new RegularGroupsImporter(dataManager, irTechFinderService),
                new RegularStudyPlanImporter(dataManager, irTechFinderService),
                new IndividualPlanSubgroupsImporter(dataManager, irTechFinderService),
                new IndividualPlanImporter(dataManager, irTechFinderService));
    }

    protected IrTechDataToDbProvider(ImportSettings importSettings,
                                  DataManager dataManager,
                                  ImportXMLToPojosConverter importXMLToPojosConverter,
                                  FileLoader fileLoader,
                                  LessonsGridService lessonsGridService,
                                  IrTechImportFinderService irTechFinderService,
                                  List<Importer> importers) {
        this.importSettings = importSettings;
        this.dataManager = dataManager;
        this.importXMLToPojosConverter = importXMLToPojosConverter;
        this.fileLoader = fileLoader;
        this.lessonsGridService = lessonsGridService;
        this.irTechFinderService = irTechFinderService;
        this.importers = importers;
    }

    public ImportFromIrtTechResult executeImport() {
        ImportFromIrtTechResultImpl importResult = new ImportFromIrtTechResultImpl();
        timeTablePojos = importXMLToPojosConverter.importData(getImportedFileAsStream());
        for (Importer importer: importers)
        {
            importResult.addResult(importer.importDataToDb(timeTablePojos, importSettings));
        }

        return importResult;
    }

    private InputStream getImportedFileAsStream() {
        try {
            return fileLoader.openStream(importSettings.getImportedFileDescriptor());
        } catch (FileStorageException e) {
            throw  new RuntimeException(e);
        }
    }
}
