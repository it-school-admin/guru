package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.Room;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.irtechimport.ImportResult;
import su.itschool.guru.service.irtechimport.pojo.RoomPojoIrTech;
import su.itschool.guru.service.irtechimport.pojo.TimeTablePojos;
import su.itschool.guru.service.irtechimport.result.SomethingImportedResult;

import java.util.List;

public class RoomImporter extends AbstractImporter<Room, RoomPojoIrTech> {

    public RoomImporter(DataManager dataManager, IrTechImportFinderService finderService) {
        super(dataManager, finderService);
    }

    @Override
    protected List<RoomPojoIrTech> getPojos(TimeTablePojos timeTablePojos) {
        return timeTablePojos.rooms;
    }

    @Override
    protected ImportResult getImportResult(TimeTablePojos timeTablePojos) {
        return new SomethingImportedResult("Импортирована информация о %0 аудиториях",
                String.valueOf(timeTablePojos.rooms.size()));
    }

    @Override
    protected void fillIrTechId(Room instance, RoomPojoIrTech pojo) {
        instance.setIrTehId(pojo.irTechId);
    }

    @Override
    protected void fillOrUpdateFields(Room instance, RoomPojoIrTech pojo, UpdateInstanceMode updateMode, ImportSettings importSettings) {
        instance.setRoomName(pojo.name);
        instance.setRoomFloor(pojo.floor);
        instance.setRoomSeatsAmount(pojo.seats);
    }


    @Override
    protected Class<Room> getClassEntityClass() {
        return Room.class;
    }

    @Override
    protected Room findExistingInstance(RoomPojoIrTech pojo) {
        return finderService.getRoomByIrTechId(pojo.irTechId);
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportRooms();
    }
}
