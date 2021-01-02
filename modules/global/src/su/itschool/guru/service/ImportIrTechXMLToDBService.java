package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.StandardEntity;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.entity.TimeTableImport;

import java.util.List;

public interface ImportIrTechXMLToDBService {
    String NAME = "guru_ImportIrTechXMLToDBService";

    @Deprecated
    List<StandardEntity> parseIrTechXML(TimeTableImport timeTableImport, LessonsGridType lessonsGridType);

    void importData(ImportSettings importSettings);
}