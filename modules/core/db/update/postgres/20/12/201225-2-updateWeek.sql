-- alter table GURU_WEEK add column EDUCATIONAL_YEAR_ID uuid ^
-- update GURU_WEEK set EDUCATIONAL_YEAR_ID = <default_value> ;
-- alter table GURU_WEEK alter column EDUCATIONAL_YEAR_ID set not null ;
alter table GURU_WEEK add column EDUCATIONAL_YEAR_ID uuid not null ;
