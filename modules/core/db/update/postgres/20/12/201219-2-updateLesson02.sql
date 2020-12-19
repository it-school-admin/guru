alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_WEEK foreign key (WEEK_ID) references GURU_WEEK(ID);
create index IDX_GURU_LESSON_ON_WEEK on GURU_LESSON (WEEK_ID);
