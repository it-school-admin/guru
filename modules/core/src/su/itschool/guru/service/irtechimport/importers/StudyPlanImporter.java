package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.SchoolClassPojo;

import java.util.Map;

public class StudyPlanImporter extends AbstractImporter {
    private final IrTechImportFinderService irTechFinderService;

    public StudyPlanImporter(Map<Integer, SchoolClassPojo> classes, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        //this.classes = classes;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        //return new ImportPlanResult();
        return null;
    }
}
