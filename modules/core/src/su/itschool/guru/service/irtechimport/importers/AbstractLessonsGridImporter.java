package su.itschool.guru.service.irtechimport.importers;

import com.haulmont.cuba.core.global.DataManager;
import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.service.ImportSettings;
import su.itschool.guru.service.IrTechImportFinderService;
import su.itschool.guru.service.LessonsGridService;
import su.itschool.guru.service.irtechimport.pojo.LessonTimePojo;


public abstract class AbstractLessonsGridImporter extends AbstractImporter<LessonsGridItem, LessonTimePojo>{
    protected final LessonsGridService lessonsGridService;

    public AbstractLessonsGridImporter(DataManager dataManager,
                                            IrTechImportFinderService finderService,
                                            LessonsGridService lessonsGridService) {
        super(dataManager, finderService);
        this.lessonsGridService = lessonsGridService;
    }

    @Override
    protected Class<LessonsGridItem> getClassEntityClass() {
        return LessonsGridItem.class;
    }

    @Override
    protected LessonsGridItem findExistingInstance(LessonTimePojo pojo) {
        return null;
    }

    @Override
    protected boolean importIsNecessary(ImportSettings importSettings) {
        return importSettings.getImportAdditionalData() && importSettings.getImportLessonsGrid();
    }

    @Override
    protected void fillIrTechId(LessonsGridItem instance, LessonTimePojo pojo) {

    }
}
