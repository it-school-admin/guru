alter table GURU_EDUCATIONAL_PERIODS add column END_DATE date ^
update GURU_EDUCATIONAL_PERIODS set END_DATE = current_date where END_DATE is null ;
alter table GURU_EDUCATIONAL_PERIODS alter column END_DATE set not null ;
alter table GURU_EDUCATIONAL_PERIODS add column START_DATE date ^
update GURU_EDUCATIONAL_PERIODS set START_DATE = current_date where START_DATE is null ;
alter table GURU_EDUCATIONAL_PERIODS alter column START_DATE set not null ;
update GURU_EDUCATIONAL_PERIODS set EDUCATIONAL_YEAR = '' where EDUCATIONAL_YEAR is null ;
alter table GURU_EDUCATIONAL_PERIODS alter column EDUCATIONAL_YEAR set not null ;
