alter table GURU_EDUCATIONAL_PERIOD rename column end_date to end_date__u61678 ;
alter table GURU_EDUCATIONAL_PERIOD alter column end_date__u61678 drop not null ;
alter table GURU_EDUCATIONAL_PERIOD add column END_DATE date ^
update GURU_EDUCATIONAL_PERIOD set END_DATE = current_date where END_DATE is null ;
alter table GURU_EDUCATIONAL_PERIOD alter column END_DATE set not null ;
