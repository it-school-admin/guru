alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_SUBJECT_ON_THE_FLY foreign key (SUBJECT_ON_THE_FLY_ID) references GURU_SUBJECT(ID);
create index IDX_GURU_LESSON_ON_SUBJECT_ON_THE_FLY on GURU_LESSON (SUBJECT_ON_THE_FLY_ID);
