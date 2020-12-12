package su.itschool.guru.web.screens.timetabletemplateitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableTemplateItem;

@UiController("guru_TimeTableTemplateItem.edit")
@UiDescriptor("time-table-template-item-edit.xml")
@EditedEntityContainer("timeTableTemplateItemDc")
@LoadDataBeforeShow
public class TimeTableTemplateItemEdit extends StandardEditor<TimeTableTemplateItem> {
}