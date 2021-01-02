package su.itschool.guru.service;

public interface ImportIrTechXMLToDBService {
    String NAME = "guru_ImportIrTechXMLToDBService";

    void importData(ImportSettings importSettings);
}