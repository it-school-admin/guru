package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.ImportResult;

public abstract class AbstractImportResult implements ImportResult {
    protected String result;

    @Override
    public String getResultString() {
        return result;
    }
}
