package su.itschool.guru.service.irtechimport.pojo;

import org.jdom2.Element;

public class RoomPojoIrTech extends AbstractPojoWithIrTechId {
    public final String name;
    public final Integer seats;
    public final Integer floor;

    public RoomPojoIrTech(Element roomElement) {
        setIrTechId(roomElement, "id");
        name = getString(roomElement, "name");
        seats = getInteger(roomElement, "seats");
        floor = getInteger(roomElement, "floor");
    }

}
