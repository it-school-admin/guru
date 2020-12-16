alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column ir_tech_id to ir_tech_id__u96829 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column time_end to time_end__u82265 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column time_end__u82265 drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column time_start to time_start__u51948 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column time_start__u51948 drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column time_table_template_id to time_table_template_id__u54352 ;
drop index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_TIME_TABLE_TEMPLATE ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column DAY_OF_WEEK varchar(255) ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set DAY_OF_WEEK = '' where DAY_OF_WEEK is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column DAY_OF_WEEK set not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column PLANNING_ITEM varchar(255) ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column SUBJECT_ID drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column GROUP_FOR_LESSON_ID drop not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column TIME_START time ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set TIME_START = current_time where TIME_START is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column TIME_START set not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column TIME_END time ^
update GURU_TIME_TABLE_TEMPLATE_ITEM set TIME_END = current_time where TIME_END is null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column TIME_END set not null ;
