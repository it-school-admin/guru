package su.itschool.guru.service;

import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(ClearDBService.NAME)
public class ClearDBServiceBean implements ClearDBService {

    @Inject
    private Persistence persistence;

    @Override
    public void clearDB() {
        persistence.callInTransaction(tr->{
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_LESSONS_PLANNING_ITEM;").executeUpdate();
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_GROUP_FOR_LESSON;").executeUpdate();
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_TEACHER;").executeUpdate();
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_SUBJECT;").executeUpdate();
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_ROOM;").executeUpdate();
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_SCHOOL_CLASS;").executeUpdate();

            return null;
        });
    }
}