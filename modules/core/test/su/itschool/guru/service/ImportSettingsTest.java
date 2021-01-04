package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import org.junit.jupiter.api.Test;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.irtechimport.pojo.AbstractPojoTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ImportSettingsTest extends AbstractPojoTest {

    @Test
    void importSettings_dont_import_lessons_grid()
    {
        ImportSettings importSettings = getImportSettings();
        importSettings.setImportLessonsGrid(false);

        assertFalse(importSettings.getImportLessonsGrid());
        assertThrows(IllegalStateException.class, ()->{
            importSettings.getLessonsGridForFirstShift();
        });

        assertThrows(IllegalStateException.class, ()->{
            importSettings.getLessonsGridForSecondShift();
        });

    }

    @Test
    void importSettings_import_lessons_grid()
    {
        FileDescriptor fileDescriptor = mock(FileDescriptor.class);
        String scheduleName = "";
        LessonsGridType firstShiftGrid = mock(LessonsGridType.class);
        LessonsGridType secondShiftGrid = mock(LessonsGridType.class);
        ImportSettings importSettings = new ImportSettings(fileDescriptor, scheduleName, false, true);
        importSettings.setImportLessonsGrid(true);
        importSettings.setLessonsGridForFirstShift(firstShiftGrid);
        importSettings.setLessonsGridForSecondShift(secondShiftGrid);


        assertTrue(importSettings.getImportLessonsGrid());
        assertEquals(firstShiftGrid, importSettings.getLessonsGridForFirstShift());
        assertEquals(secondShiftGrid, importSettings.getLessonsGridForSecondShift());
    }

    @Test
    void importSettings_import_subjects()
    {
        ImportSettings importSettings = getImportSettings();

        importSettings.setImportSubjects(true);
        assertTrue(importSettings.getImportSubjects());

        importSettings.setImportSubjects(false);
        assertFalse(importSettings.getImportSubjects());
    }

    @Test
    void importSettings_import_teachers()
    {
        ImportSettings importSettings = getImportSettings();

        importSettings.setImportTeachers(true);
        assertTrue(importSettings.getImportTeachers());

        importSettings.setImportTeachers(false);
        assertFalse(importSettings.getImportTeachers());
    }

    @Test
    void importSettings_import_rooms()
    {
        ImportSettings importSettings = getImportSettings();

        importSettings.setImportRooms(true);
        assertTrue(importSettings.getImportRooms());

        importSettings.setImportRooms(false);
        assertFalse(importSettings.getImportRooms());
    }

    @Test
    void importSettings_import_study_plan()
    {
        ImportSettings importSettings = getImportSettings();

        importSettings.setImportStudyPlan(true);
        assertTrue(importSettings.getImportStudyPlan());

        importSettings.setImportStudyPlan(false);
        assertFalse(importSettings.getImportStudyPlan());
    }

    @Test
    void importSettings_import_classes()
    {
        ImportSettings importSettings = getImportSettings();

        importSettings.setImportClasses(true);
        assertTrue(importSettings.getImportClasses());

        importSettings.setImportClasses(false);
        assertFalse(importSettings.getImportClasses());
    }



    private ImportSettings getImportSettings() {
        FileDescriptor fileDescriptor = mock(FileDescriptor.class);
        String scheduleName = "";
        return new ImportSettings(fileDescriptor, scheduleName, false, true);
    }


}