package su.itschool.guru.web.screens.eductaionalyear;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EductaionalYear;

@UiController("guru_EductaionalYear.edit")
@UiDescriptor("eductaional-year-edit.xml")
@EditedEntityContainer("eductaionalYearDc")
@LoadDataBeforeShow
public class EductaionalYearEdit extends StandardEditor<EductaionalYear> {
}