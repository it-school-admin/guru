package su.itschool.guru.web.screens.week;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.EducationalYear;
import su.itschool.guru.entity.Week;
import su.itschool.guru.service.FillingWeeksService;

import javax.inject.Inject;

@UiController("guru_Week.browse")
@UiDescriptor("week-browse.xml")
@LookupComponent("weeksTable")
@LoadDataBeforeShow
public class WeekBrowse extends StandardLookup<Week> {
    @Inject
    private FillingWeeksService fillingWeeksService;
    @Inject
    private CollectionContainer<EducationalYear> educationalYearsDc;

    @Subscribe("fillWeeksBtn")
    public void onFillWeeksBtnClick(Button.ClickEvent event) {
        fillingWeeksService.fillWeeks(educationalYearsDc.getItem());
    }
}