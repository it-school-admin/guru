alter table GURU_WEEK_DAY rename column day_number to day_number__u12502 ;
alter table GURU_WEEK_DAY alter column day_number__u12502 drop not null ;
-- alter table GURU_WEEK_DAY add column DAY_NUMBER integer ^
-- update GURU_WEEK_DAY set DAY_NUMBER = <default_value> ;
-- alter table GURU_WEEK_DAY alter column day_number set not null ;
alter table GURU_WEEK_DAY add column DAY_NUMBER integer ;
