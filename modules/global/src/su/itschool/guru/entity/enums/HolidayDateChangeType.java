package su.itschool.guru.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

public enum HolidayDateChangeType implements EnumClass<Integer> {
    WORKING_DAY(10),
    NOT_WORKING_DAY(20),
    SHORTENED_DAY(30);

    private final Integer id;

    HolidayDateChangeType(Integer id) {

        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    //todo add test
    public static HolidayDateChangeType fromId(Integer id){
        for(HolidayDateChangeType holidayDateChangeType: HolidayDateChangeType.values())
        {
            if(holidayDateChangeType.getId().equals(id))
                return holidayDateChangeType;
        }
        //TODO add exception?
        return null;
    }
}
