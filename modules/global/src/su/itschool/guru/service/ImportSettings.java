package su.itschool.guru.service;

import java.io.File;
import java.io.Serializable;

public class ImportSettings implements Serializable {
    private final File importedFile;
    private final String scheduleName;
    private final Boolean importAllClasses;
    private final Boolean importAdditionalData;

    public ImportSettings(File importedFile, String scheduleName, Boolean importAllClasses, Boolean importAdditionalData) {
        this.importedFile = importedFile;
        this.scheduleName = scheduleName;
        this.importAllClasses = importAllClasses;
        this.importAdditionalData = importAdditionalData;
    }

    public Boolean getImportAllClasses() {
        return importAllClasses;
    }

    public Boolean getImportAdditionalData() {
        return importAdditionalData;
    }

    public File getImportedFile() {
        return importedFile;
    }
}
