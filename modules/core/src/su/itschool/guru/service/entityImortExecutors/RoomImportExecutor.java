package su.itschool.guru.service.entityImortExecutors;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.w3c.dom.Node;
import su.itschool.guru.entity.Room;

public class RoomImportExecutor extends AbstractImportExecutorImpl {
    public RoomImportExecutor(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected StandardEntity setEntityFields(StandardEntity entity, Node entityInformation) {
//TODO		<room id="53207" name="2" seats="30" floor="1"/>

        Room room = (Room) entity;
        room.setIrTehId(getID(entityInformation, "id"));
        room.setRoomName(getStringAttributeValue(entityInformation, "id"));
        room.setRoomFloor(getStringAttributeValue(entityInformation, "floor"));
        room.setRoomSeatsAmount(getIntegerAttributeValue(entityInformation, "seats"));
        return entity;
    }
}
