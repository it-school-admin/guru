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
    public final List<RoomPojoIrTech> rooms = new ArrayList();
    public final List<SchoolClassPojo> classes = new ArrayList();
    public final List<RootSubjectPojo> rootSubjects = new ArrayList();
    public final List<RegularSubgroupPojo> regularSubGroups = new ArrayList();
    public final List<IndividualPlanSubgroupPojo> individualPlanSubgroups = new ArrayList();
    public final List<RegularPlanItemPojo> regularPlanItems = new ArrayList();
    public final List<LessonPojo> lessons = new ArrayList();
    public final List<IndividualPlanItemPojo> individualPlanItems = new ArrayList();
}
