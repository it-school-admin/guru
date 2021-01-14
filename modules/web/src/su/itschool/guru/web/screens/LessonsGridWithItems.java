package su.itschool.guru.web.screens;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogActions;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogOutcome;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;
import su.itschool.guru.service.LessonsGridItemsService;

import javax.inject.Inject;
import java.util.Set;

@UiController("guru_LessonsGridWithItems")
@UiDescriptor("lessons-grid-with-items.xml")
public class LessonsGridWithItems extends Screen {
    @Inject
    private CollectionLoader<LessonsGridType> lessonsGridTypesDl;
    @Inject
    private CollectionLoader<LessonsGridItem> lessonsGridItemsDl;
    @Inject
    private LessonsGridItemsService lessonsGridItemsService;
    @Inject
    private GroupTable<LessonsGridType> lessonsGridTypesTable;
    @Inject
    private Dialogs dialogs;
    @Inject
    private GroupTable<LessonsGridItem> lessonsGridItemsTable;
    @Inject
    private Button shiftTimeOfLessonsBtn;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        lessonsGridTypesDl.load();
    }

    @Subscribe("lessonsGridTypesTable")
    public void onLessonsGridTypesTableSelection(Table.SelectionEvent<LessonsGridType> event) {
        if(event.getSelected().size()>0)
        {
            lessonsGridItemsDl.setParameter("grid", event.getSelected().iterator().next());
            lessonsGridItemsDl.load();
        }
    }

    @Subscribe("fillGridItemsBtn")
    public void onFillGridItemsClick(Button.ClickEvent event) {
        LessonsGridType selectedLessonsGrid = lessonsGridTypesTable.getSingleSelected();
        if(selectedLessonsGrid != null )
        {
            notifyAndExecuteAboutDeleting(selectedLessonsGrid);
        }
    }

    private void notifyAndExecuteAboutDeleting(LessonsGridType selectedLessonsGrid) {
        //TODO localize
        dialogs.createOptionDialog()
                .withCaption("Подтверждение")
                .withMessage("Все элементы сетки уроков перед заполнением будут удалены")
                .withActions(
                        new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                            executeFilling(selectedLessonsGrid);
                        }),
                        new DialogAction(DialogAction.Type.NO)
                    )
                .show();
    }

    private void executeFilling(LessonsGridType selectedLessonsGrid) {
        lessonsGridItemsService.createGridItems(selectedLessonsGrid);
        lessonsGridItemsDl.load();
    }

    @Subscribe("shiftTimeOfLessonsBtn")
    public void onShiftTimeOfLessonsBtnClick(Button.ClickEvent event) {
        Set<LessonsGridItem> selectedGridItems = lessonsGridItemsTable.getSelected();
        if(selectedGridItems.size()>0)
        {
            startShiftingWithQuestion(selectedGridItems);
        }
    }

    private void startShiftingWithQuestion(Set<LessonsGridItem> selectedGridItems) {
        dialogs.createInputDialog(this)
                .withCaption("Смещение времени уроков")
                .withParameters(
                        InputParameter.intParameter("shift")
                                .withRequired(true)
                                .withCaption("Смещение (в минутах)")
                                .withDefaultValue(10)
                )
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent->{
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        executeShifting(selectedGridItems, closeEvent.getValue("shift"));
                    }

                })
                .show();
    }

    private void executeShifting(Set<LessonsGridItem> selectedGridItems, Integer shift) {
        lessonsGridItemsService.shiftItems(selectedGridItems, shift);
        lessonsGridItemsDl.load();
    }

    @Subscribe("lessonsGridItemsTable")
    public void onLessonsGridItemsTableSelection(Table.SelectionEvent<LessonsGridItem> event) {
        if(event.getSelected().size()>0)
        {
            shiftTimeOfLessonsBtn.setEnabled(true);
        }
        else
        {
            shiftTimeOfLessonsBtn.setEnabled(false);
        }
    }
}