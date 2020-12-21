alter table GURU_LESSON rename column study_group_id to study_group_id__u10993 ;
alter table GURU_LESSON alter column study_group_id__u10993 drop not null ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_STUDY_GROUP ;
drop index IDX_GURU_LESSON_ON_STUDY_GROUP ;
alter table GURU_LESSON add column GROUP_ON_THE_FLY_ID uuid ;
