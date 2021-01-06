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
import java.util.UUID;

import static com.haulmont.cuba.core.app.events.EntityChangedEvent.Type.*;

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

    private SchoolClass loadSchoolClass(Id<SchoolClass, UUID> classId) {

        return dataManager.load(SchoolClass.class).id(classId.getValue()).one();
    }

    private void createRootGroupForLesson(SchoolClass schoolClass) {
        GroupForLesson rootClassGroup = dataManager.create(GroupForLesson.class);
        rootClassGroup.setSchoolClass(schoolClass);
        dataManager.commit(rootClassGroup);
    }
}