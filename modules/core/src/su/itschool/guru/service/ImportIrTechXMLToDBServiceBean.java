package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import org.springframework.stereotype.Service;
import su.itschool.guru.service.irtechimport.ImportXMLToPojosConverter;
import su.itschool.guru.service.irtechimport.IrTechDataToDbProvider;

import javax.inject.Inject;


//TODO very bad code. Rewrite all!!!
@Service(ImportIrTechXMLToDBService.NAME)
public class ImportIrTechXMLToDBServiceBean implements ImportIrTechXMLToDBService {
    @Inject
    private DataManager dataManager;
    @Inject
    private IrTechImportFinderService irTechfinderService;
    @Inject
    private FileLoader fileLoader;
    @Inject
    private LessonsGridService lessonsGridService;


    @Override
    public String importData(ImportSettings importSettings) {
        IrTechDataToDbProvider irTechDataToDbProvider = new IrTechDataToDbProvider(
                importSettings,
                dataManager,
                new ImportXMLToPojosConverter(),
                fileLoader,
                lessonsGridService,
                irTechfinderService);
        return irTechDataToDbProvider.executeImport().getResultText();
    }



}