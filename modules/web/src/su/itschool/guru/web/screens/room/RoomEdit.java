package su.itschool.guru.web.screens.room;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Room;

@UiController("guru_Room.edit")
@UiDescriptor("room-edit.xml")
@EditedEntityContainer("roomDc")
@LoadDataBeforeShow
public class RoomEdit extends StandardEditor<Room> {
}