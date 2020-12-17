-- alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column DAY_OF_WEEK_ID uuid ^
-- update GURU_TIME_TABLE_TEMPLATE_ITEM set DAY_OF_WEEK_ID = <default_value> ;
-- alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column DAY_OF_WEEK_ID set not null ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column DAY_OF_WEEK_ID uuid not null ;
