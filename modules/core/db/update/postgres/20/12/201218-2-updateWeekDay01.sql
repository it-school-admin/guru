-- update GURU_WEEK_DAY set DAY_NUMBER = <default_value> where DAY_NUMBER is null ;
alter table GURU_WEEK_DAY alter column DAY_NUMBER set not null ;
