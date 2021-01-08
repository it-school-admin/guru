package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.ImportResult;

public class NothingImportedResult implements ImportResult
{
    public static NothingImportedResult nothingImported()
    {
        return new NothingImportedResult();
    }

    @Override
    public String getResultString() {
        //TODO message text
        throw new IllegalStateException();
    }

    @Override
    public Boolean isImported() {
        return false;
    }
}
