package su.itschool.guru.service;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.entity.enums.WeekDay;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Service(LessonsGridItemsService.NAME)
public class LessonsGridItemsServiceBean implements LessonsGridItemsService {

    @Inject
    private DataManager dataManager;

    public void createGridItems(LessonsGridType gridType) {

        clearItems(gridType);

        LessonsGridType gridTypeWithParameters = dataManager.reload(gridType, "_local");

        Integer standardAmountOfLessons = gridTypeWithParameters.getStandardAmountOfLessons();
        LessonTimeCalculator lessonTimeCalculator = new LessonTimeCalculator(gridTypeWithParameters);
        for (int lessonNumber=1; lessonNumber<=standardAmountOfLessons; lessonNumber++)
        {
            for(int dayOfWeekNumber = 1; dayOfWeekNumber<=gridTypeWithParameters.getStudyDaysAmount();dayOfWeekNumber++)
            {
                createItem(gridTypeWithParameters, lessonNumber, dayOfWeekNumber,lessonTimeCalculator);
            }
        }
    }

    @Override
    public void shiftItems(Set<LessonsGridItem> selectedGridItems, Integer shift) {
        for (LessonsGridItem gridItem: selectedGridItems)
        {
            gridItem.setLessonStartTime(gridItem.getLessonStartTime().plusMinutes(shift));
        }
        dataManager.commit(new CommitContext(selectedGridItems));
    }

    private void clearItems(LessonsGridType gridType) {

        Collection<LessonsGridItem> toDeleteItems = dataManager
                .load(LessonsGridItem.class)
                .query("select e from guru_LessonsGridItem e where e.gridType=:gridType")
                .parameter("gridType", gridType)
                .list();
        dataManager.commit(new CommitContext(Collections.EMPTY_SET, toDeleteItems));
    }

    private void createItem(LessonsGridType gridType, int lessonNumber, int dayOfWeek, LessonTimeCalculator lessonTimeCalculator) {
        LessonsGridItem lessonsGridItem = dataManager.create(LessonsGridItem.class);
        lessonsGridItem.setGridType(gridType);
        lessonsGridItem.setWeekDay(WeekDay.fromId(dayOfWeek));
        lessonsGridItem.setLessonNumber(lessonNumber);
        lessonsGridItem.setLessonStartTime(lessonTimeCalculator.getStartTime(lessonNumber));
        dataManager.commit(lessonsGridItem);
    }

    static class LessonTimeCalculator {
        private final LessonsGridType gridType;

        public LessonTimeCalculator(LessonsGridType gridType) {

            this.gridType = gridType;
        }

        public LocalTime getStartTime(Integer lessonNumber) {
            if (lessonNumber ==1)
            {
                return gridType.getStartTime();
            }
            return gridType.getStartTime().plusMinutes((lessonNumber-1)*(gridType.getDefaultLessonTime()+gridType.getDefaultPauseDuration()));
        }
    }
}