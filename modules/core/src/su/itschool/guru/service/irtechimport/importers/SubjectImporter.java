package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RootSubjectPojo;
import su.itschool.guru.service.irtechimport.pojo.SubjectPojo;
import su.itschool.guru.service.irtechimport.result.SubjectImportResult;

import java.util.HashMap;
import java.util.Map;

public class SubjectImporter extends AbstractImporter {
    private final Map<Integer, SubjectPojo> subjectPojos;
    private final Map<Integer, RootSubjectPojo> rootSubjectsPojos;
    private final IrTechImportFinderService irTechFinderService;
    private final Map<Integer, Subject> rootSubjects = new HashMap();


    public SubjectImporter(Map<Integer, SubjectPojo> subjectPojos, Map<Integer, RootSubjectPojo> rootSubjects, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.subjectPojos = subjectPojos;
        this.rootSubjectsPojos = rootSubjects;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {

        createOrUpdateRootSubjects();

        createOrUpdateSubjects();

        return new SubjectImportResult(subjectPojos.size() + rootSubjectsPojos.size());
    }

    private void createOrUpdateSubjects() {
        for (Map.Entry<Integer, SubjectPojo> subjectPojoEntry: subjectPojos.entrySet())
        {
            SubjectPojo subjectPojo = subjectPojoEntry.getValue();
            Subject subject = irTechFinderService.findSubjectByIrTechId(subjectPojoEntry.getKey());
            if(subject == null)
            {
                subject = dataManager.create(Subject.class);
                subject.setIrTechId(subjectPojo.irTechId);
            }
            subject.setSubjectName(subjectPojo.name);
            subject.setShortenedName(subjectPojo.abbr);
            Integer parentSubjectId = subjectPojo.getParentSubject();
            if(parentSubjectId != null)
            {
                subject.setParentSubject(rootSubjects.get(parentSubjectId));
            }
            dataManager.commit(subject);
        }
    }

    private void createOrUpdateRootSubjects() {
        for (Map.Entry<Integer, RootSubjectPojo> rootSubjectPojoEntry: rootSubjectsPojos.entrySet())
        {
            RootSubjectPojo rootSubjectPojo = rootSubjectPojoEntry.getValue();
            Subject subject = irTechFinderService.findSubjectByIrTechId(rootSubjectPojoEntry.getKey());
            if(subject == null)
            {
                subject = dataManager.create(Subject.class);
                subject.setIrTechId(rootSubjectPojo.irTechId);
            }
            subject.setSubjectName(rootSubjectPojo.name);
            rootSubjects.put(rootSubjectPojo.irTechId, subject);
            dataManager.commit(subject);
        }

    }
}
