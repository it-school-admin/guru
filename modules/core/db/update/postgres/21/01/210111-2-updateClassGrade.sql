-- alter table GURU_CLASS_GRADE add column LEVEL_ID uuid ^
-- update GURU_CLASS_GRADE set LEVEL_ID = <default_value> ;
-- alter table GURU_CLASS_GRADE alter column LEVEL_ID set not null ;
alter table GURU_CLASS_GRADE add column LEVEL_ID uuid not null ;
