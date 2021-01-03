package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import su.itschool.guru.entity.LessonsGridType;

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
    private LessonsGridType lessonsGridForFirstShift;
    private LessonsGridType lessonsGridForSecondShift;

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
        return importLessonsGrid;
    }

    public void setImportLessonsGrid(Boolean importLessonsGrid) {

        this.importLessonsGrid = importLessonsGrid;
    }

    public void setSelectedClasses(Set<Integer> selectedClassesIds) {

        this.selectedClassesIds = selectedClassesIds;
    }

    public void setLessonsGridForFirstShift(LessonsGridType lessonsGrid) {

        this.lessonsGridForFirstShift = lessonsGrid;
    }

    public LessonsGridType getLessonsGridForFirstShift() {
        if (importLessonsGrid)
        {
            return lessonsGridForFirstShift;
        }
        else
        {
            //TODO message
            throw new IllegalStateException();
        }
    }

    public LessonsGridType getLessonsGridForSecondShift() {
        if (importLessonsGrid)
        {
            return lessonsGridForSecondShift;
        }
        else
        {
            //TODO message
            throw new IllegalStateException();
        }
    }

    public void setLessonsGridForSecondShift(LessonsGridType lessonsGrid) {
        lessonsGridForSecondShift = lessonsGrid;
    }
}
