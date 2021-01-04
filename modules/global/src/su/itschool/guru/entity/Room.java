package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_ROOM")
@Entity(name = "guru_Room")
@NamePattern("%s %s|roomName,roomBlock")
public class Room extends StandardEntity {
    private static final long serialVersionUID = -5861697168919518406L;

    @NotNull
    @Column(name = "ROOM_NAME", nullable = false)
    private String roomName;

    @JoinColumn(name = "ROOM_BLOCK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Block roomBlock;

    @Column(name = "ROOM_FLOOR")
    private Integer roomFloor;

    @Column(name = "ROOM_SEATS_AMOUNT")
    private Integer roomSeatsAmount;

    @Column(name = "IR_TEH_ID")
    private Integer irTehId;

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setIrTehId(Integer irTehId) {
        this.irTehId = irTehId;
    }

    public Integer getIrTehId() {
        return irTehId;
    }

    public Integer getRoomSeatsAmount() {
        return roomSeatsAmount;
    }

    public void setRoomSeatsAmount(Integer roomSeatsAmount) {
        this.roomSeatsAmount = roomSeatsAmount;
    }

    public void setRoomBlock(Block roomBlock) {
        this.roomBlock = roomBlock;
    }

    public Block getRoomBlock() {
        return roomBlock;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}