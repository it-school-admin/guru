package su.itschool.guru.web.screens.eductaionalyear;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EductaionalYear;

@UiController("guru_EductaionalYear.browse")
@UiDescriptor("eductaional-year-browse.xml")
@LookupComponent("eductaionalYearsTable")
@LoadDataBeforeShow
public class EductaionalYearBrowse extends StandardLookup<EductaionalYear> {
}