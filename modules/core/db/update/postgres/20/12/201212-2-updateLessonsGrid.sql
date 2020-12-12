alter table GURU_LESSONS_GRID add column LESSONS_GRID_TYPE_NAME varchar(255) ^
update GURU_LESSONS_GRID set LESSONS_GRID_TYPE_NAME = '' where LESSONS_GRID_TYPE_NAME is null ;
alter table GURU_LESSONS_GRID alter column LESSONS_GRID_TYPE_NAME set not null ;
