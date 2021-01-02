package su.itschool.guru.service.irtechimport.pojo;

import java.util.HashMap;
import java.util.Map;

public class TimeTablePojos {
    public Map<Integer, LessonTimePojo> firstShiftLessonsTimes = new HashMap();
    public Map<Integer, LessonTimePojo> secondShiftLessonsTimes = new HashMap();

    public Map<Integer, TeacherPojo> teachers = new HashMap();
}
