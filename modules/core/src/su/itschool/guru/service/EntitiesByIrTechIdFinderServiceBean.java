package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;
import su.itschool.guru.entity.Subject;
import su.itschool.guru.entity.Teacher;

import javax.inject.Inject;

@Service(EntitiesByIrTechIdFinderService.NAME)
public class EntitiesByIrTechIdFinderServiceBean implements EntitiesByIrTechIdFinderService {

    @Inject
    private DataManager dataManager;

    @Override
    public Teacher findTeacherByIrTechId(Integer irTechId) {
        try {
            Teacher teacher = dataManager.
                    load(Teacher.class).
                    query("SELECT t FROM guru_Teacher t WHERE t.irTechId = :irTechId").
                    parameter("irTechId", irTechId).
                    one();

            return teacher;
        }
        catch (Exception e)
        {
            //TODO
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Subject findSubjectByIrTechId(Integer irTechId) {
        try {
            Subject subject = dataManager.
                    load(Subject.class).
                    query("SELECT s FROM guru_Subject s WHERE s.irTechId = :irTechId").
                    parameter("irTechId", irTechId).
                    one();

            return subject;
        }
        catch (Exception e)
        {
            //TODO
            return null;
        }
    }

    @Override
    public GroupForLesson findLearningSubGroup(Integer groupIrTechId, SchoolClass schoolClass, Integer subjectIrTechId) {
        try {
            GroupForLesson groupForLesson = dataManager.
                    load(GroupForLesson.class).
                    query("select gr from guru_GroupForLesson as gr " +
                            "JOIN gr.subject sub " +
                            "WHERE " +
                            "gr.schoolClass = :schoolClass " +
                            "AND sub.irTechId = :subjectIrTechId " +
                            "AND gr.groupIrTechId = :groupIrTechId").
                    parameter("groupIrTechId", groupIrTechId).
                    parameter("subjectIrTechId", subjectIrTechId).
                    parameter("schoolClass", schoolClass).
                    one();

            return groupForLesson;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public GroupForLesson findMainLearningGroup(Integer classIrTechId, Integer subjectIrTechId) {
        try {
            GroupForLesson groupForLesson = dataManager.
                    load(GroupForLesson.class).
                    query("select gr from guru_GroupForLesson as gr " +
                            "JOIN gr.schoolClass cl " +
                            "JOIN gr.subject sub " +
                            "WHERE " +
                            "gr.isFullClassGroup = true " +
                            "AND sub.irTechId = :subjectIrTechId " +
                            "AND cl.irTechId = :classIrTechId").
                    parameter("classIrTechId", classIrTechId).
                    parameter("subjectIrTechId", subjectIrTechId).
                    one();

            return groupForLesson;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }
}