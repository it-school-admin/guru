alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_TEACHER_ON_THE_FLY foreign key (TEACHER_ON_THE_FLY_ID) references GURU_TEACHER(ID);
create index IDX_GURU_LESSON_ON_TEACHER_ON_THE_FLY on GURU_LESSON (TEACHER_ON_THE_FLY_ID);