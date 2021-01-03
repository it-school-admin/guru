package su.itschool.guru.service;

import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.LessonsGridType;

import javax.inject.Inject;

@Service(LessonsGridService.NAME)
public class LessonsGridServiceBean implements LessonsGridService {

    @Inject
    private Persistence persistence;

    @Override
    public void clearLessonsGrid(LessonsGridType lessonsGrid) {
        persistence.callInTransaction(tr->{
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_LESSONS_GRID_ITEM " +
                    "WHERE GRID_TYPE_ID='" + lessonsGrid.getId().toString() + "';").executeUpdate();

            return null;
        });
    }
}