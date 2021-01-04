package su.itschool.guru.service.irtechimport.result;

public class RoomImportResult extends AbstractImportResult{
    public RoomImportResult(Integer roomsCount) {
        result = "Импортирована информация о " + roomsCount + " аудиториях";
    }
}
