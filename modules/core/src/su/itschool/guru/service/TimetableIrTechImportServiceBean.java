package su.itschool.guru.service;

import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import su.itschool.guru.entity.TimetableTemplate;

import javax.inject.Inject;

@Service(TimetableIrTechImportService.NAME)
public class TimetableIrTechImportServiceBean implements TimetableIrTechImportService {

    @Inject
    private Persistence persistence;

    @Override
    public void clearTimeTableTemplate(TimetableTemplate timetableTemplate) {
        persistence.callInTransaction(tr->{
            persistence.getEntityManager().createNativeQuery("DELETE FROM GURU_TIME_TABLE_TEMPLATE_ITEM " +
                    "WHERE TIMETABLE_TEMPLATE_ID='" + timetableTemplate.getId().toString() + "';").executeUpdate();

            return null;
        });
    }
}