package su.itschool.guru.listeners;

import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import su.itschool.guru.entity.GroupForLesson;
import su.itschool.guru.entity.SchoolClass;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static com.haulmont.cuba.core.app.events.EntityChangedEvent.Type.CREATED;
import static com.haulmont.cuba.core.app.events.EntityChangedEvent.Type.DELETED;

@Component("guru_SchoolClassChangedListener")
public class SchoolClassChangedListener {

    @Inject
    private DataManager dataManager;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<SchoolClass, UUID> event) {
        Id<SchoolClass, UUID> classId = event.getEntityId();
        if(event.getType()== CREATED)
        {
            createRootGroupForLesson(loadSchoolClass(classId));
        }
    }


    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<SchoolClass, UUID> event) {
        Id<SchoolClass, UUID> classId = event.getEntityId();
        if(event.getType()== DELETED)
        {
            removeRelatedWithClassGroups(classId);
        }
    }

    private void removeRelatedWithClassGroups(Id<SchoolClass, UUID> classId) {
        List<GroupForLesson> schoolClasses = dataManager
                .load(GroupForLesson.class)
                .query("SELECT gp FROM guru_GroupForLesson AS gp" +
                        " WHERE gp.schoolClass=:schoolClass")
                .parameter("schoolClass", loadSchoolClass(classId))
                .list();
        for(GroupForLesson groupForLesson: schoolClasses)
        {
            dataManager.remove(groupForLesson);
        }
    }

    private SchoolClass loadSchoolClass(Id<SchoolClass, UUID> classId) {

        return dataManager.load(SchoolClass.class).id(classId.getValue()).one();
    }

    private void createRootGroupForLesson(SchoolClass schoolClass) {
        GroupForLesson rootClassGroup = dataManager.create(GroupForLesson.class);
        rootClassGroup.setSchoolClass(schoolClass);
        dataManager.commit(rootClassGroup);
    }
}