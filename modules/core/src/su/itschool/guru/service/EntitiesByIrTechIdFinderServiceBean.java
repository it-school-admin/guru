package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.GroupForLesson;
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
    public GroupForLesson findSubGroupByIrTechId(Integer irTechId) {
        try {
            GroupForLesson groupForLesson = dataManager.
                    load(GroupForLesson.class).
                    query("select gr from guru_GroupForLesson as gr " +
                            "WHERE " +
                            "gr.groupIrTechId = :groupIrTechId").
                    parameter("groupIrTechId", irTechId).
                    one();

            return groupForLesson;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public GroupForLesson findMainGroupByClassIrTechID(Integer classIrTechId) {
        try {
            GroupForLesson groupForLesson = dataManager.
                    load(GroupForLesson.class).
                    query("select gr from guru_GroupForLesson as gr " +
                            "JOIN gr.schoolClass cl " +
                            "WHERE " +
                            "gr.isFullClassGroup = true " +
                            "AND gr.irTechId = :classIrTechId").
                    parameter("classIrTechId", classIrTechId).
                    one();

            return groupForLesson;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }
}