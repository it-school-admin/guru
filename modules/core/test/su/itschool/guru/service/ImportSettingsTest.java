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
        FileDescriptor fileDescriptor = mock(FileDescriptor.class);
        String scheduleName = "";
        ImportSettings importSettings = new ImportSettings(fileDescriptor, scheduleName, false, true);
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

}