-- alter table GURU_TEACHER add column ORGANIZATION_ID uuid ^
-- update GURU_TEACHER set ORGANIZATION_ID = <default_value> ;
-- alter table GURU_TEACHER alter column ORGANIZATION_ID set not null ;
alter table GURU_TEACHER add column ORGANIZATION_ID uuid not null ;
