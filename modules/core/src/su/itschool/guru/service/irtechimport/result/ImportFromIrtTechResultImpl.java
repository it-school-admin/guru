package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.ImportFromIrtTechResult;
import su.itschool.guru.service.irtechimport.ImportResult;

import java.util.ArrayList;
import java.util.List;

public class ImportFromIrtTechResultImpl implements ImportFromIrtTechResult
{
    //TODO localize
    public static final String NOTHING_IS_IMPORTED = "Ничего не импортировано";
    List<ImportResult> importResults = new ArrayList();


    @Override
    public void addResult(ImportResult importResult) {
        importResults.add(importResult);
    }

    @Override
    public String getResultText() {
        List<ImportResult> onlyImportedResults = getOnlyImportedResults();
        String result = "";
        int size = onlyImportedResults.size();

        if(size == 0)
        {
            return NOTHING_IS_IMPORTED;
        }

        int i = 1;
        for (ImportResult importResult: onlyImportedResults)
        {
            result += importResult.getResultString();
            if (i < size)
            {
                result += System.lineSeparator();
            }
            i++;
        }
        return result;
    }

    private List<ImportResult> getOnlyImportedResults() {
        List<ImportResult> clearedList = new ArrayList();
        for(ImportResult result: importResults)
        {
            if(result.isImported())
            {
                clearedList.add(result);
            }
        }
        return clearedList;
    }
}
