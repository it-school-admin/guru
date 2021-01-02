package su.itschool.guru.service.irtechimport;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

public class IrTechDataToDbProvider {
    private final ImportSettings importSettings;
    private final DataManager dataManager;
    private TimeTablePojos timeTablePojos;

    public IrTechDataToDbProvider(ImportSettings importSettings, DataManager dataManager) {
        this.importSettings = importSettings;
        this.dataManager = dataManager;
    }

    public void executeImport() {
        if (importSettings.getImportAdditionalData())
        {
            if(importSettings.getImportLessonsGrid())
            {
                //importLessonsGrid(timeTablePojos);
            }
        }
    }
}
