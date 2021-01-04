package su.itschool.guru.service;

import su.itschool.guru.service.irtechimport.ImportFromIrtTechResult;

public interface ImportIrTechXMLToDBService {
    String NAME = "guru_ImportIrTechXMLToDBService";

    String importData(ImportSettings importSettings);
}