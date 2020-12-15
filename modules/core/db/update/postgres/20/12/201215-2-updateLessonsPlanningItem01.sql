alter table GURU_LESSONS_PLANNING_ITEM rename column hours_per_week to hours_per_week__u51927 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column hours_per_week__u51927 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM add column HOURS_PER_WEEK integer ^
update GURU_LESSONS_PLANNING_ITEM set HOURS_PER_WEEK = 0 where HOURS_PER_WEEK is null ;
alter table GURU_LESSONS_PLANNING_ITEM alter column HOURS_PER_WEEK set not null ;
