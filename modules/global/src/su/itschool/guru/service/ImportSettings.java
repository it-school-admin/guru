package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.entity.TimetableTemplate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ImportSettings implements Serializable {
    private final FileDescriptor importedFileDescriptor;
    private final Boolean importTimetable;
    private final TimetableTemplate timetableTemplate;
    private final Boolean importTimeTableForAllClasses;
    private final Boolean importAdditionalData;
    private Set<Integer> selectedClassesIds = new HashSet();
    private Boolean importLessonsGrid;
    private LessonsGridType lessonsGridForFirstShift;
    private LessonsGridType lessonsGridForSecondShift;
    private Boolean importSubjects;
    private Boolean importTeachers;
    private Boolean importRooms;
    private Boolean importStudyPlan;
    private Boolean importClasses;

    public ImportSettings(FileDescriptor fileDescriptor, Boolean importTimetable, TimetableTemplate timetableTemplate, Boolean importTimeTableForAllClasses, Boolean importAdditionalData) {
        this.importedFileDescriptor = fileDescriptor;
        this.importTimetable = importTimetable;
        this.timetableTemplate = timetableTemplate;
        this.importTimeTableForAllClasses = importTimeTableForAllClasses;
        this.importAdditionalData = importAdditionalData;
    }

    public Boolean getImportTimeTableForAllClasses() {
        return importTimeTableForAllClasses;
    }

    public Boolean getImportAdditionalData() {
        return importAdditionalData;
    }

    public FileDescriptor getImportedFileDescriptor() {
        return importedFileDescriptor;
    }

    public Boolean getImportLessonsGrid() {
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

    public Boolean getImportSubjects() {
        return importSubjects;

    }

    public void setImportSubjects(Boolean importSubjects) {
        this.importSubjects = importSubjects;
    }

    public void setImportTeachers(Boolean importTeachers) {

        this.importTeachers = importTeachers;
    }

    public void setImportRooms(Boolean importRooms) {

        this.importRooms = importRooms;
    }

    public void setImportStudyPlan(Boolean importStudyPlan) {

        this.importStudyPlan = importStudyPlan;
    }

    public Boolean getImportTeachers() {
        return importTeachers;
    }

    public Boolean getImportRooms() {
        return importRooms;
    }

    public Boolean getImportStudyPlan() {
        return importStudyPlan;
    }

    public void setImportClasses(Boolean importClasses) {

        this.importClasses = importClasses;
    }

    public boolean getImportClasses() {
        return importClasses;
    }

    public Boolean getImportTimetable() {
        return importTimetable;
    }

    public Set<Integer> getSelectedClassesIds() {
        return selectedClassesIds;
    }

    public TimetableTemplate getTimetableTemplate() {
        return timetableTemplate;
    }
}
