package su.itschool.guru.web.screens;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.entity.SchoolClass;

import javax.inject.Inject;

@UiController("guru_TimetableMaking")
@UiDescriptor("timetable-making.xml")
public class TimetableMaking extends Screen {
    @Inject
    private CollectionLoader<SchoolClass> schoolClassesDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        schoolClassesDl.load();
    }
}