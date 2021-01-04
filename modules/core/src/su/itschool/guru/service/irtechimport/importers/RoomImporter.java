package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Room;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.AbstractImporter;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RoomPojo;
import su.itschool.guru.service.irtechimport.result.RoomImportResult;

import java.util.Map;

public class RoomImporter extends AbstractImporter {
    private final Map<Integer, RoomPojo> rooms;
    private final IrTechImportFinderService irTechFinderService;

    public RoomImporter(Map<Integer, RoomPojo> rooms, DataManager dataManager, IrTechImportFinderService irTechFinderService) {
        super(dataManager);
        this.rooms = rooms;
        this.irTechFinderService = irTechFinderService;
    }

    @Override
    public ImportResult importDataToDb() {
        for (Map.Entry<Integer, RoomPojo> roomPojoEntry: rooms.entrySet())
        {
            RoomPojo roomPojo = roomPojoEntry.getValue();
            Room room = irTechFinderService.getRoomByIrTechId(roomPojo.irTechId);
            if(room == null)
            {
                room = dataManager.create(Room.class);
                room.setIrTehId(roomPojo.irTechId);
            }
            room.setRoomName(roomPojo.name);
            room.setRoomFloor(roomPojo.floor);
            room.setRoomSeatsAmount(roomPojo.seats);
            dataManager.commit(room);
        }
        return new RoomImportResult(rooms.size());
    }
}
