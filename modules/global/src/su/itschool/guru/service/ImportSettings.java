package su.itschool.guru.service;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ImportSettings implements Serializable {
    private final File importedFile;
    private final String scheduleName;
    private final Boolean importAllClasses;
    private final Boolean importAdditionalData;
    private Set<Integer> selectedClassesIds = new HashSet();
    private Boolean importLessonsGrid;

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

    public boolean getImportLessonsGrid() {
        return false;
    }

    public void setAdditionalData(Boolean importLessonsGrid) {

        this.importLessonsGrid = importLessonsGrid;
    }

    public void setSelectedClasses(Set<Integer> selectedClassesIds) {

        this.selectedClassesIds = selectedClassesIds;
    }
}
