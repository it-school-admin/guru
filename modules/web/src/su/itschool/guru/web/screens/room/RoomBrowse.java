package su.itschool.guru.web.screens.room;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Room;

@UiController("guru_Room.browse")
@UiDescriptor("room-browse.xml")
@LookupComponent("roomsTable")
@LoadDataBeforeShow
public class RoomBrowse extends StandardLookup<Room> {
}