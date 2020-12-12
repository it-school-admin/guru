package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_ROOM")
@Entity(name = "guru_Room")
public class Room extends StandardEntity {
    private static final long serialVersionUID = -5861697168919518406L;

    @NotNull
    @Column(name = "ROOM_NAME", nullable = false)
    private String roomName;

    @Column(name = "IR_TEH_ID")
    private String irTehId;

    public String getIrTehId() {
        return irTehId;
    }

    public void setIrTehId(String irTehId) {
        this.irTehId = irTehId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}