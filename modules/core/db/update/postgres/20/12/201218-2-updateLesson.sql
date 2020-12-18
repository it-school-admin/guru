alter table GURU_LESSON rename column end_time to end_time__u30105 ;
alter table GURU_LESSON alter column end_time__u30105 drop not null ;
alter table GURU_LESSON rename column start_time to start_time__u35205 ;
alter table GURU_LESSON alter column start_time__u35205 drop not null ;
alter table GURU_LESSON rename column teacher_id to teacher_id__u10652 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_TEACHER ;
drop index IDX_GURU_LESSON_ON_TEACHER ;
alter table GURU_LESSON rename column subject_id to subject_id__u46575 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_SUBJECT ;
drop index IDX_GURU_LESSON_ON_SUBJECT ;
alter table GURU_LESSON add column TOPIC_OF_THE_LESSON text ;
alter table GURU_LESSON add column PLANNING_ITEM_ID uuid ;
alter table GURU_LESSON add column HOME_TASK_DESRIPTION text ;
alter table GURU_LESSON add column ROOM_ID uuid ;
alter table GURU_LESSON add column TEACHER_ON_THE_FLY_ID uuid ;
alter table GURU_LESSON add column TOOLS_DESCRIPTION varchar(255) ;
alter table GURU_LESSON add column SUBJECT_ON_THE_FLY_ID uuid ;
alter table GURU_LESSON add column START_TIME timestamp ^
update GURU_LESSON set START_TIME = current_timestamp where START_TIME is null ;
alter table GURU_LESSON alter column START_TIME set not null ;
alter table GURU_LESSON add column END_TIME timestamp ^
update GURU_LESSON set END_TIME = current_timestamp where END_TIME is null ;
alter table GURU_LESSON alter column END_TIME set not null ;
