alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column day_of_week to day_of_week__u14877 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column day_of_week__u14877 drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column DAY_OF_WEEK integer ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set DAY_OF_WEEK = 0 where DAY_OF_WEEK is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column DAY_OF_WEEK set not null ;
