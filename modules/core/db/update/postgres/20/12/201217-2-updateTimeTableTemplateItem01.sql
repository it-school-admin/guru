alter table GURU_TIME_TABLE_TEMPLATE_ITEM add constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_PLANNING_ITEM foreign key (PLANNING_ITEM_ID) references GURU_LESSONS_PLANNING_ITEM(ID);
create index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_PLANNING_ITEM on GURU_TIME_TABLE_TEMPLATE_ITEM (PLANNING_ITEM_ID);
