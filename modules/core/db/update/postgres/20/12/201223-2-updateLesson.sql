alter table GURU_LESSON rename column end_time to end_time__u39749 ;
alter table GURU_LESSON alter column end_time__u39749 drop not null ;
alter table GURU_LESSON add column DURATION integer ^
update GURU_LESSON set DURATION = 0 where DURATION is null ;
alter table GURU_LESSON alter column DURATION set not null ;
