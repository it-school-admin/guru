package su.itschool.guru.service.irtechimport.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTablePojos {
    public final Map<Integer, LessonTimePojo> firstShiftLessonsTimes = new HashMap();
    public final Map<Integer, LessonTimePojo> secondShiftLessonsTimes = new HashMap();

    public final Map<Integer, TeacherPojo> teachers = new HashMap();
    public final Map<Integer, SubjectPojo> subjects = new HashMap();
    public final Map<Integer, RoomPojo> rooms = new HashMap();
    public final Map<Integer, SchoolClassPojo> classes = new HashMap();
    public final Map<Integer, RootSubjectPojo> rootSubjects = new HashMap();
    public final Map<Integer, RegularSubgroupPojo> regularSubGroups = new HashMap();
    public final Map<Integer, IndividualPlanSubgroupPojo> planItemIdsWithIndividualPlanSubgroups = new HashMap();
    public final Map<Integer, PlanItemPojo> planItems = new HashMap();
    public final List<LessonPojo> lessons = new ArrayList();
}
