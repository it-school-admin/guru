package su.itschool.guru.listeners;

import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.UUID;

@Component("guru_LessonsGridTypeChangedListener")
public class LessonsGridTypeChangedListener {

    @Inject
    private DataManager dataManager;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<LessonsGridType, UUID> event) {
        LessonsGridType gridType = getGridType(event);
        createGridItems(gridType);
    }

    private void createGridItems(LessonsGridType gridType) {
        Integer standardAmountOfLessons = gridType.getStandardAmountOfLessons();
        LessonTimeCalculator lessonTimeCalculator = new LessonTimeCalculator(gridType);
        for (int i=0; i<standardAmountOfLessons; i++)
        {
            createItem(gridType, i+1, lessonTimeCalculator);
        }
    }

    private void createItem(LessonsGridType gridType, int lessonNumber, LessonTimeCalculator lessonTimeCalculator) {
        LessonsGridItem lessonsGridItem = dataManager.create(LessonsGridItem.class);
        lessonsGridItem.setGridType(gridType);
        lessonsGridItem.setLessonNumber(lessonNumber);
        lessonsGridItem.setLessonStartTime(lessonTimeCalculator.getStartTime(lessonNumber));
        dataManager.commit(lessonsGridItem);
    }

    private LessonsGridType getGridType(EntityChangedEvent<LessonsGridType, UUID> event) {
        return dataManager.load(event.getEntityId()).view("_local").one();
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