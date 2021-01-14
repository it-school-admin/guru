package su.itschool.guru.service;

import su.itschool.guru.entity.LessonsGridItem;
import su.itschool.guru.entity.LessonsGridType;

import java.util.Set;

public interface LessonsGridItemsService {
    String NAME = "guru_LessonsGridItemsService";
    void createGridItems(LessonsGridType gridType);

    void shiftItems(Set<LessonsGridItem> selectedGridItems, Integer shift);
}