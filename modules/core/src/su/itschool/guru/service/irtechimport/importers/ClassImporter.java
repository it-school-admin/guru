package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.SchoolClassPojo;
import su.itschool.guru.service.irtechimport.result.ClassesImportResult;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

public class ClassImporter extends AbstractImporter {
    private final Map<Integer, SchoolClassPojo> classes;
    private final IrTechImportFinderService irTechFinderService;

    public ClassImporter(Map<Integer, SchoolClassPojo> classes, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.classes = classes;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for (Map.Entry<Integer, SchoolClassPojo> classPojoEntry: classes.entrySet())
        {
            SchoolClassPojo schoolClassPojo = classPojoEntry.getValue();
            SchoolClass schoolClass = irTechFinderService.findClassByIrTechId(schoolClassPojo.irTechId);
            if(schoolClass == null)
            {
                schoolClass = dataManager.create(SchoolClass.class);
                schoolClass.setIrTechId(schoolClassPojo.irTechId);
            }
            schoolClass.setClassLevel(schoolClassPojo.grade);
            schoolClass.setClassLetter(schoolClassPojo.letter);
            schoolClass.setStudentCount(schoolClassPojo.countOfStudents);
            dataManager.commit(schoolClass);

        }

        return new ClassesImportResult(classes.size());
    }
}
