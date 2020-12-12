package su.itschool.guru.web.screens.timetabletemplateitem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.TimeTableTemplateItem;

@UiController("guru_TimeTableTemplateItem.browse")
@UiDescriptor("time-table-template-item-browse.xml")
@LookupComponent("timeTableTemplateItemsTable")
@LoadDataBeforeShow
public class TimeTableTemplateItemBrowse extends StandardLookup<TimeTableTemplateItem> {
}