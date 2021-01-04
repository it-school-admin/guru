package su.itschool.guru.web.screens;

import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;

import javax.inject.Inject;

@UiController("guru_LessonsGridWithItems")
@UiDescriptor("lessons-grid-with-items.xml")
public class LessonsGridWithItems extends Screen {
    @Inject
    private CollectionLoader<LessonsGridType> lessonsGridTypesDl;
    @Inject
    private CollectionLoader<LessonsGridItem> lessonsGridItemsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        lessonsGridTypesDl.load();
    }

    @Subscribe("lessonsGridTypesTable")
    public void onLessonsGridTypesTableSelection(Table.SelectionEvent<LessonsGridType> event) {
        lessonsGridItemsDl.setParameter("grid", event.getSelected().iterator().next());
        lessonsGridItemsDl.load();
    }
}