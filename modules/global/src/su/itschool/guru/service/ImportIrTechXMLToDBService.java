package su.itschool.guru.service;

import com.haulmont.cuba.core.entity.StandardEntity;
import su.itschool.guru.entity.TimeTableImport;

import java.util.List;

public interface ImportIrTechXMLToDBService {
    String NAME = "guru_ImportIrTechXMLToDBService";

    List<StandardEntity> parseIrTechXML (TimeTableImport timeTableImport);
}