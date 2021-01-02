package su.itschool.guru.service;

public class IrTechDataToDbProvider {
    private ImportSettings importSettings;

    public IrTechDataToDbProvider(ImportSettings importSettings) {
        this.importSettings = importSettings;
    }

    public void executeImport() {
        if (importSettings.getImportAdditionalData())
        {
            if(importSettings.getImportLessonsGrid())
            {
               // jlkjl
            }
        }
    }
}
