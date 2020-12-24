package su.itschool.guru.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

public enum WeekDay implements EnumClass<Integer> {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer id;

    WeekDay(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public static WeekDay fromId(Integer id){
        for(WeekDay weekDay: WeekDay.values())
        {
            if(weekDay.getId().equals(id))
                return weekDay;
        }
        //TODO add exception?
        return null;
    }

}
