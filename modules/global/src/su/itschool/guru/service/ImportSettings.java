package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.FileDescriptor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ImportSettings implements Serializable {
    private final FileDescriptor importedFileDescriptor;
    private final String scheduleName;
    private final Boolean importAllClasses;
    private final Boolean importAdditionalData;
    private Set<Integer> selectedClassesIds = new HashSet();
    private Boolean importLessonsGrid;

    public ImportSettings(FileDescriptor fileDescriptor, String scheduleName, Boolean importAllClasses, Boolean importAdditionalData) {
        this.importedFileDescriptor = fileDescriptor;
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

    public FileDescriptor getImportedFileDescriptor() {
        return importedFileDescriptor;
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
