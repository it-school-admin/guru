-- alter table GURU_LESSON add column WEEK_ID uuid ^
-- update GURU_LESSON set WEEK_ID = <default_value> ;
-- alter table GURU_LESSON alter column WEEK_ID set not null ;
alter table GURU_LESSON add column WEEK_ID uuid not null ;
