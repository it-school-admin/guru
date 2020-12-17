alter table GURU_TIME_TABLE_TEMPLATE_ITEM add constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_DAY_OF_WEEK foreign key (DAY_OF_WEEK_ID) references GURU_WEEK_DAY(ID);
create index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_DAY_OF_WEEK on GURU_TIME_TABLE_TEMPLATE_ITEM (DAY_OF_WEEK_ID);
