package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Room;
import su.itschool.guru.service.IrTechImportFinderService;

public class RoomImportExecutor extends AbstractImportExecutorImpl {


    public RoomImportExecutor(Class entityClass, IrTechImportFinderService irTechImportFinderService, DataManager dataManager) {
        super(entityClass, irTechImportFinderService, dataManager);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation, Node rootNode, StandardEntity rootEntity) {
//TODO		<room id="53207" name="2" seats="30" floor="1"/>

        Room room = (Room) entity;
        room.setIrTehId(getIntegerAttributeValue(entityInformation, "id"));
        room.setRoomName(getStringAttributeValue(entityInformation, "name"));
      //  room.setRoomFloor(getStringAttributeValue(entityInformation, "floor"));
        room.setRoomSeatsAmount(getIntegerAttributeValue(entityInformation, "seats"));
        return entity;
    }


    @Override
    public StandardEntity findEntity(Node rootNode, StandardEntity rootEntity, Node entityInformation) {
        return null;
    }
}
