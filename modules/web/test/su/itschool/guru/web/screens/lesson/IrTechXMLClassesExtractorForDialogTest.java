package su.itschool.guru.web.screens.lesson;

import com.haulmont.cuba.core.entity.FileDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class IrTechXMLClassesExtractorForDialogTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void extractSchoolClassesIdsToClassesNamesMap() {

    /*    List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

// selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

        //Mockito

     */
        FileDescriptor fileDescriptorMock = mock(FileDescriptor.class);
        IrTechXMLClassesExtractorForDialog irTechXMLClassesExtractorForDialog = new IrTechXMLClassesExtractorForDialog();
        Map<Integer, String> classesIdsToClassesNamesMap = irTechXMLClassesExtractorForDialog.extractSchoolClassesIdsToClassesNamesMap(fileDescriptorMock);
        assertEquals(26, classesIdsToClassesNamesMap.size());
       // irTechXMLClassesExtractorForDialog.extractSchoolClassesIdsToClassesNamesMap()
    }
    
}