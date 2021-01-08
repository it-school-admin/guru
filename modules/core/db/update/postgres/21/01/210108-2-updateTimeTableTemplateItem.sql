-- alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column TIMETABLE_TEMPLATE_ID uuid ^
-- update GURU_TIME_TABLE_TEMPLATE_ITEM set TIMETABLE_TEMPLATE_ID = <default_value> ;
-- alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column TIMETABLE_TEMPLATE_ID set not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column TIMETABLE_TEMPLATE_ID uuid not null ;
