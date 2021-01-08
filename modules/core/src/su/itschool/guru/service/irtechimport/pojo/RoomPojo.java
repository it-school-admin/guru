package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RoomPojo extends AbstractPojoWithIrTechId {
    public final String name;
    public final Integer seats;
    public final Integer floor;

    public RoomPojo(Element roomElement) {
        setIrTechId(roomElement, "id");
        name = getString(roomElement, "name");
        seats = getInteger(roomElement, "seats");
        floor = getInteger(roomElement, "floor");
    }

}
