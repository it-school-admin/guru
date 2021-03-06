package su.itschool.guru.service.irtechimport.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTablePojos {
    public final List<LessonTimePojo> firstShiftLessonsTimes = new ArrayList();
    public final List<LessonTimePojo> secondShiftLessonsTimes = new ArrayList();

    public final List<TeacherPojo> teachers = new ArrayList();
    public final Map<Integer, SubjectPojo> subjects = new HashMap();
    public final List<RoomPojo> rooms = new ArrayList();
    public final List<SchoolClassPojo> classes = new ArrayList();
    public final Map<Integer, RootSubjectPojo> rootSubjects = new HashMap();
    public final List<RegularSubgroupPojo> regularSubGroups = new ArrayList();
    public final List<IndividualPlanSubgroupPojo> individualPlanSubgroups = new ArrayList();
    public final Map<Integer, RegularPlanItemPojo> regularPlanItems = new HashMap();
    public final Map<Integer, IndividualPlanItemPojo> individualPlanItems = new HashMap();
    public final List<LessonPojo> lessons = new ArrayList();
}
