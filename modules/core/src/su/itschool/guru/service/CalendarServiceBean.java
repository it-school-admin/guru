package su.itschool.guru.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.Lesson;

import javax.inject.Inject;

@Service(CalendarService.NAME)
public class CalendarServiceBean implements CalendarService {

    @Inject
    private DataManager dataManager;

    @Override
    public String calculateCaptionForCalendarEvent(Lesson lesson) {

        Lesson loadedLesson = dataManager
                .load(Lesson.class)
                .viewProperties("planningItem",
                        "planningItem.groupOfLearning",
                        "planningItem.groupOfLearning.isFullClassGroup",
                        "planningItem.groupOfLearning.subGroupName",
                        "planningItem.groupOfLearning.schoolClass",
                        "planningItem.groupOfLearning.schoolClass.className",
                        "planningItem.groupOfLearning.subject",
                        "planningItem.groupOfLearning.subject.subjectName"
                        )
                .query("SELECT les FROM guru_Lesson AS les WHERE les.id=:lesson_id")
                .parameter("lesson_id", lesson.getId())
                .one();

/*        LoadContext<Lesson> loadContext = LoadContext.create(Lesson.class)
                .setId(lesson).setView("lesson-view-for-caption");*/
 /*       Lesson loadedLesson = dataManager.load(loadContext);*/

        return "none";

/*        if (loadedLesson.getPlanningItem() != null) {
            GroupForLesson groupOfLearning = loadedLesson.getPlanningItem().getGroupOfLearning();
            if (groupOfLearning.getIsFullClassGroup()) {
                return groupOfLearning.getSchoolClass().getClassName() +
                        " " +
                        groupOfLearning.getSubject().getSubjectName();

            } else {
                return groupOfLearning.getSchoolClass().getClassName() +
                        " " +
                        groupOfLearning.getSubject().getSubjectName() +
                        " " +
                        groupOfLearning.getSubGroupName();
            }
        } else {
            return "";
        }*/
    }
}