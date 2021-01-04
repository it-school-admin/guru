package su.itschool.guru.service.irtechimport;

import com.haulmont.cuba.core.global.DataManager;

public abstract class AbstractImporter {
    protected final DataManager dataManager;

    protected AbstractImporter(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    public abstract ImportResult importDataToDb();
}
