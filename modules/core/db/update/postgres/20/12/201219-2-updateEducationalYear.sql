alter table GURU_EDUCATIONAL_YEAR rename column end_date to end_date__u55464 ;
alter table GURU_EDUCATIONAL_YEAR alter column end_date__u55464 drop not null ;
alter table GURU_EDUCATIONAL_YEAR rename column start_date to start_date__u01730 ;
alter table GURU_EDUCATIONAL_YEAR alter column start_date__u01730 drop not null ;
alter table GURU_EDUCATIONAL_YEAR add column START_DATE date ^
update GURU_EDUCATIONAL_YEAR set START_DATE = current_date where START_DATE is null ;
alter table GURU_EDUCATIONAL_YEAR alter column START_DATE set not null ;
alter table GURU_EDUCATIONAL_YEAR add column END_DATE date ^
update GURU_EDUCATIONAL_YEAR set END_DATE = current_date where END_DATE is null ;
alter table GURU_EDUCATIONAL_YEAR alter column END_DATE set not null ;
