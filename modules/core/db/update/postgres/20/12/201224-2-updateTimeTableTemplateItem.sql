alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column time_end to time_end__u50751 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column time_end__u50751 drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column time_start to time_start__u29185 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column time_start__u29185 drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column NUMBER_OF_LESSON integer ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set NUMBER_OF_LESSON = 0 where NUMBER_OF_LESSON is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column NUMBER_OF_LESSON set not null ;
