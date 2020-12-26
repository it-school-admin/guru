package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.IrTechImportFinderService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LessonsGridItemsImportExecutor extends AbstractImportExecutorImpl {
    private final LessonsGridType lessonsGridType;
//		<LessonTime id="1" starttime="8:00" endtime="8:40" sm="1" number="1" />

    public LessonsGridItemsImportExecutor(Class<LessonsGridItem> lessonsGridItem, IrTechImportFinderService finderService, DataManager dataManager, LessonsGridType lessonsGridType) {
        super(lessonsGridItem, finderService, dataManager);
        this.lessonsGridType = lessonsGridType;
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
        LessonsGridItem lessonsGridItem = (LessonsGridItem) entity;
        lessonsGridItem.setGridType(lessonsGridType);
     //   lessonsGridItem.setIrTechId(getIntegerAttributeValue(entityInformation, "id"));
       // lessonsGridItem.setIrTechShift(getIntegerAttributeValue(entityInformation,"sm"));

        //TODO
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        lessonsGridItem.setLessonStartTime(LocalTime.parse(getStringAttributeValue(entityInformation,"starttime"), timeFormatter));
       // lessonsGridItem.setLessonEndTime(LocalTime.parse(getStringAttributeValue(entityInformation,"endtime"), timeFormatter));
        return entity;
    }

    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
