package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.ClassGrade;
import su.itschool.guru.entity.StudyLevel;
import su.itschool.guru.entity.enums.PlanningType;

import javax.inject.Inject;

@Service(GradesService.NAME)
public class GradesServiceBean implements GradesService {

    @Inject
    private DataManager dataManager;

    @Override
    public BulkCreationResult createGrades(Integer from, Integer to, StudyLevel level, PlanningType planningType) {
        BulkCreationResult result = new BulkCreationResult();

        for (int gradeNumber=from;gradeNumber<=to;gradeNumber++)
        {
            ClassGrade classGrade = dataManager.create(ClassGrade.class);
            classGrade.setGradeNumber(gradeNumber);
            classGrade.setLevel(level);
            classGrade.setPlanningType(planningType);

            try {
                dataManager.commit(classGrade);
            }
            catch (Exception e)
            {
                result.addErrorResult(String.valueOf(gradeNumber));
            }
        }
        return result;
    }
}