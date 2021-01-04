package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Teacher;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.TeacherPojo;
import su.itschool.guru.service.irtechimport.result.TeachersImportResult;

import java.util.Map;

public class TeacherImporter extends AbstractImporter {
    private final Map<Integer, TeacherPojo> teachers;
    private final IrTechImportFinderService irTechFinderService;

    public TeacherImporter(Map<Integer, TeacherPojo> teachers, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.teachers = teachers;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for(Map.Entry<Integer, TeacherPojo> teacherPojoEntry: teachers.entrySet())
        {
            TeacherPojo teacherPojo = teacherPojoEntry.getValue();
            Teacher teacher = irTechFinderService.findTeacherByIrTechId(teacherPojo.irTechId);
            if(teacher == null)
            {
                teacher = dataManager.create(Teacher.class);
                teacher.setIrTechId(teacherPojo.irTechId);
            }
            teacher.setTeacherName(teacherPojo.name);
            teacher.setTeacherSecondName(teacherPojo.middleName);
            teacher.setTeacherFamilyName(teacherPojo.lastName);

            dataManager.commit(teacher);

        }
        return new TeachersImportResult(teachers.size());
    }
}
