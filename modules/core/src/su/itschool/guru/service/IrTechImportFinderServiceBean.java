package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.*;

import javax.inject.Inject;

@Service(IrTechImportFinderService.NAME)
public class IrTechImportFinderServiceBean implements IrTechImportFinderService {

    @Inject
    private DataManager dataManager;

    @Override
    public Teacher findTeacherByIrTechId(Integer irTechId) {
        try {
            Teacher teacher = dataManager.
                    load(Teacher.class).
                    query("SELECT t FROM guru_Teacher t" +
                            " WHERE t.irTechId = :irTechId").
                    parameter("irTechId", irTechId).
                    one();

            return teacher;
        }
        catch (Exception e)
        {
            //TODO avoid exception appearing
           // e.printStackTrace();
            return null;
        }
    }

    @Override
    public Subject findSubjectByIrTechId(Integer irTechId) {
        try {

            Subject subject = dataManager
                    .load(Subject.class)
                  //  .view("subject-view-with-parent")
                    .viewProperties("subjectName","shortenedName","parentSubject", "irTechId")
                    .query("SELECT s FROM guru_Subject s WHERE s.irTechId = :irTechId")
                    .parameter("irTechId", irTechId).
                    one();
            return subject;
        }
        catch (Exception e)
        {
            //TODO
            return null;
        }
    }

    //TODO make two methods. One is for update. Second is for getting refference to entity.
    @Override
    public GroupForLesson findSubGroupByIrTechIdAndClass(Integer irTechId, Integer schoolClassIrTechId) {
        try {

            GroupForLesson groupForLesson = dataManager
                    .load(GroupForLesson.class)
                    .viewProperties("ownName", "parentGroup", "irTechId", "countStudent", "schoolClass", "schoolClass.irTechId")
                    .query("SELECT g FROM guru_GroupForLesson g" +
                            " JOIN g.schoolClass cl " +
                            " WHERE g.irTechId = :irTechId" +
                            " AND cl.irTechId = :classIrTechId")
                    .parameter("irTechId", irTechId)
                    .parameter("classIrTechId", schoolClassIrTechId)
                    .one();
            return groupForLesson;
        }
        catch (Exception e)
        {
            //TODO
            return null;
        }
    }

    @Override
    public GroupForLesson findRootClassGroup(Integer classIrTechId) {
        try {
            GroupForLesson groupForLesson = dataManager.
                    load(GroupForLesson.class)
                    .viewProperties("parentGroup", "schoolClass.irTechId", "schoolClass")
                    .query("select gr from guru_GroupForLesson as gr " +
                            "JOIN gr.schoolClass cl " +
                            "WHERE " +
                            "gr.parentGroup IS NULL " +
                            "AND cl.irTechId = :classIrTechId")
                    .parameter("classIrTechId", classIrTechId)
                    .one();

            return groupForLesson;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public LessonsPlanningItem getPlanningItemByIrTechId(Integer irTechId) {
        try {
            LessonsPlanningItem lessonsPlanningItem = dataManager.
                    load(LessonsPlanningItem.class)
                    .view("lessonsPlanningItem-view")
                    .query("select pi from guru_LessonsPlanningItem as pi " +
                            "WHERE " +
                            "pi.irTechID = :irTechId").
                    parameter("irTechId", irTechId).
                    one();

            return lessonsPlanningItem;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public Room getRoomByIrTechId(Integer irTechId) {
        try {
            Room room = dataManager.
                    load(Room.class).
                    query("select rm from guru_Room as rm " +
                            "WHERE " +
                            "rm.irTechId = :irTechId").
                    parameter("irTechId", irTechId).
                    one();

            return room;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public SchoolClass findClassByIrTechId(Integer irTechId) {
        try {
            SchoolClass schoolClass = dataManager
                    .load(SchoolClass.class)
                    .view("schoolClass-view-for-import")
                    .query("select cl from guru_SchoolClass as cl " +
                            "WHERE " +
                            "cl.irTechId = :irTechId")
                    .parameter("irTechId", irTechId)
                    .one();

            return schoolClass;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

    @Override
    public GroupForIndividualPlanning findIndividualPlanSubgroupByPlanItemIrTechId(Integer planItemIrTechId) {
        try {
            GroupForIndividualPlanning group = dataManager.
                    load(GroupForIndividualPlanning.class)
                    .view("groupForIndividualPlanning-view")
                    .query("select g from guru_GroupForIndividualPlanning as g " +
                            "WHERE " +
                            "g.planItemIrTechId = :irTechId")
                    .parameter("irTechId", planItemIrTechId).
                    one();

            return group;
        } catch (Exception e) {
            //TODO
            return null;
        }

    }

    @Override
    public ClassGrade findGradeByNumber(Integer gradeNumber) {
        try {
            ClassGrade grade = dataManager.
                    load(ClassGrade.class)
                    .query("select g from guru_ClassGrade as g " +
                            "WHERE " +
                            "g.gradeNumber = :gradeNumber")
                    .parameter("gradeNumber", gradeNumber).
                            one();

            return grade;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }
}