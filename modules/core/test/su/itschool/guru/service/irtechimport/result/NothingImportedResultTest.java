package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NothingImportedResultTest {

    @Test
    void testIsImported(){
        NothingImportedResult nothingImportedResult = new NothingImportedResult();
        assertFalse(nothingImportedResult.isImported());
    }


    @Test
    void testException(){
        NothingImportedResult nothingImportedResult = new NothingImportedResult();
        assertThrows(IllegalStateException.class , ()->{nothingImportedResult.getResultString();});
    }

}