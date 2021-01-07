package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.IndividualPlanItemPojo;
import su.itschool.guru.service.irtechimport.result.IndividualPlanImportResult;

import java.util.List;

public class IndividualPlanImporter extends AbstractImporter {
    private final List<IndividualPlanItemPojo> individualPlanItems;
    private final IrTechImportFinderService irTechFinderService;

    public IndividualPlanImporter(List<IndividualPlanItemPojo> individualPlanItems, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.individualPlanItems = individualPlanItems;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        return new IndividualPlanImportResult(individualPlanItems.size());
    }
}
