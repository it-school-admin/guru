update GURU_WEEK set WEEK_NUMBER = 0 where WEEK_NUMBER is null ;
alter table GURU_WEEK alter column WEEK_NUMBER set not null ;
