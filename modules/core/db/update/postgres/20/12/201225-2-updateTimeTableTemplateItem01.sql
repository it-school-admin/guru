alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column group_for_lesson_id to group_for_lesson_id__u35940 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM drop constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_GROUP_FOR_LESSON ;
drop index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_GROUP_FOR_LESSON ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column WEEK_DAY integer ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set WEEK_DAY = 1 where WEEK_DAY is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column WEEK_DAY set not null ;
