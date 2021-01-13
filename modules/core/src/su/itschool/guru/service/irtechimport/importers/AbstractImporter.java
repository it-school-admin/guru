package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.AbstractPojo;
import su.itschool.guru.service.irtechimport.pojo.AbstractPojoWithIrTechId;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

import java.util.Collection;

import static su.itschool.guru.service.irtechimport.importers.AbstractImporter.UpdateInstanceMode.EXISTING_INSTANCE;
import static su.itschool.guru.service.irtechimport.importers.AbstractImporter.UpdateInstanceMode.NEW_INSTANCE;
import static su.itschool.guru.service.irtechimport.result.NothingImportedResult.nothingImported;

public abstract class AbstractImporter<E extends StandardEntity, P extends AbstractPojo> implements Importer{
    public enum UpdateInstanceMode {NEW_INSTANCE, EXISTING_INSTANCE};
    protected final DataManager dataManager;
    protected final IrTechImportFinderService finderService;

    public AbstractImporter(DataManager dataManager, IrTechImportFinderService finderService)
    {
        this.dataManager = dataManager;
        this.finderService = finderService;
    }

    @Override
    public final ImportResult importDataToDb(TimeTablePojos timeTablePojos, ImportSettings importSettings)
    {
        if(importIsNecessary(importSettings))
        {
            executeBeforeImportActions(timeTablePojos, importSettings);
            for (P pojo: getPojos(timeTablePojos))
            {
                E existingInstance = findExistingInstance(pojo);
                if (existingInstance == null)
                {
                    existingInstance = dataManager.create(getClassEntityClass());
                    if(pojo instanceof AbstractPojoWithIrTechId)
                    {
                        fillIrTechId(existingInstance, pojo);
                    }
                    fillOrUpdateFields(existingInstance, pojo, NEW_INSTANCE, importSettings, finderService);
                }
                else
                {
                    fillOrUpdateFields(existingInstance, pojo, EXISTING_INSTANCE, importSettings, finderService);

                }
                dataManager.commit(existingInstance);
            }
            return getImportResult(timeTablePojos);
        }
        else
        {
            return nothingImported();
        }
    }

    protected void executeBeforeImportActions(TimeTablePojos timeTablePojos, ImportSettings importSettings) {

    }

    protected abstract Collection<P> getPojos(TimeTablePojos timeTablePojos);

    protected abstract ImportResult getImportResult(TimeTablePojos timeTablePojos);

    protected abstract void fillIrTechId(E instance, P pojo);

    protected abstract void fillOrUpdateFields(E instance, P pojo, UpdateInstanceMode updateMode, ImportSettings importSettings, IrTechImportFinderService finderService);

    protected abstract Class<E> getClassEntityClass();

    protected abstract E findExistingInstance(P pojo);

    protected abstract boolean importIsNecessary(ImportSettings importSettings);
}
