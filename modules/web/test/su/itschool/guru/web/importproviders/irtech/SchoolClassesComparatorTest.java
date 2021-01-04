package su.itschool.guru.web.importproviders.irtech;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SchoolClassesComparatorTest {

    @Test
    void testCompare_first_is_more_by_letter()
    {
        SchoolClassWrapper class_1a = mock(SchoolClassWrapper.class);
        Mockito.when(class_1a.getGrade()).thenReturn(1);
        Mockito.when(class_1a.getLetter()).thenReturn('А');

        SchoolClassWrapper class_1b = mock(SchoolClassWrapper.class);
        Mockito.when(class_1b.getGrade()).thenReturn(1);
        Mockito.when(class_1b.getLetter()).thenReturn('Б');

        SchoolClassesComparator schoolClassesComparator = new SchoolClassesComparator();
        assertEquals(1, schoolClassesComparator.compare(class_1b, class_1a));
    }

    @Test
    void testCompare_first_is_less_by_letter()
    {
        SchoolClassWrapper class_1a = mock(SchoolClassWrapper.class);
        Mockito.when(class_1a.getGrade()).thenReturn(1);
        Mockito.when(class_1a.getLetter()).thenReturn('А');

        SchoolClassWrapper class_1b = mock(SchoolClassWrapper.class);
        Mockito.when(class_1b.getGrade()).thenReturn(1);
        Mockito.when(class_1b.getLetter()).thenReturn('Б');

        SchoolClassesComparator schoolClassesComparator = new SchoolClassesComparator();
        assertEquals(-1, schoolClassesComparator.compare(class_1a, class_1b));
    }

    @Test
    void testCompare_first_is_more_by_number()
    {
        SchoolClassWrapper class_10a = mock(SchoolClassWrapper.class);
        Mockito.when(class_10a.getGrade()).thenReturn(10);
        Mockito.when(class_10a.getLetter()).thenReturn('А');

        SchoolClassWrapper class_1b = mock(SchoolClassWrapper.class);
        Mockito.when(class_1b.getGrade()).thenReturn(1);
        Mockito.when(class_1b.getLetter()).thenReturn('Б');

        SchoolClassesComparator schoolClassesComparator = new SchoolClassesComparator();
        assertEquals(1, schoolClassesComparator.compare(class_10a, class_1b));
    }

    @Test
    void testCompare_first_is_less_by_number()
    {
        SchoolClassWrapper class_10a = mock(SchoolClassWrapper.class);
        Mockito.when(class_10a.getGrade()).thenReturn(10);
        Mockito.when(class_10a.getLetter()).thenReturn('А');

        SchoolClassWrapper class_1b = mock(SchoolClassWrapper.class);
        Mockito.when(class_1b.getGrade()).thenReturn(1);
        Mockito.when(class_1b.getLetter()).thenReturn('Б');

        SchoolClassesComparator schoolClassesComparator = new SchoolClassesComparator();
        assertEquals(-1, schoolClassesComparator.compare(class_1b, class_10a));
    }

}