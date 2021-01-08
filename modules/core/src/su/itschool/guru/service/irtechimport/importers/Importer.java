package su.itschool.guru.service.irtechimport.importers;

import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;

public interface Importer {
    ImportResult importDataToDb(TimeTablePojos timeTablePojos, ImportSettings importSettings);
}
