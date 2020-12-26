package su.itschool.guru.listeners;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.listener.AfterInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeDeleteEntityListener;
import org.springframework.stereotype.Component;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;

import javax.inject.Inject;
import java.sql.Connection;

@Component("guru_SchoolClassEntityListener")
public class SchoolClassEntityListener implements AfterInsertEntityListener<SchoolClass>, BeforeDeleteEntityListener<SchoolClass> {
    @Inject
    private DataManager dataManager;
    @Inject
    private Persistence persistence;

    @Override
    public void onAfterInsert(SchoolClass entity, Connection connection) {
        GroupForLesson rootClassGroup = dataManager.create(GroupForLesson.class);
        rootClassGroup.setSchoolClass(entity);
        dataManager.commit(rootClassGroup);
    }

    @Override
    public void onBeforeDelete(SchoolClass entity, EntityManager entityManager) {
        persistence.callInTransaction(tr->{
            persistence
                    .getEntityManager()
                    .createNativeQuery("DELETE FROM GURU_GROUP_FOR_LESSON WHERE SCHOOL_CLASS_ID="+entity.getId().toString()+";")
                    .executeUpdate();
            //TODO
            return null;
        });
    }
}
