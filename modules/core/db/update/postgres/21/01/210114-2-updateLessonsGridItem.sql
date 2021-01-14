alter table GURU_LESSONS_GRID_ITEM add column WEEK_DAY integer ^
update GURU_LESSONS_GRID_ITEM set WEEK_DAY = 1 where WEEK_DAY is null ;
alter table GURU_LESSONS_GRID_ITEM alter column WEEK_DAY set not null ;
