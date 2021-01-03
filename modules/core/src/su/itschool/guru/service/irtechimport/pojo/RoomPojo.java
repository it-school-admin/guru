package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RoomPojo extends AbstractPojoWithId {
    public String name;
    public Integer seats;
    public Integer floor;

    public RoomPojo(Element roomElement) {
        setIrTechId(roomElement, "id");
        name = getString(roomElement, "name");
        seats = getInteger(roomElement, "seats");
        floor = getInteger(roomElement, "floor");
    }

}
