alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_ROOM foreign key (ROOM_ID) references GURU_ROOM(ID);
create index IDX_GURU_LESSON_ON_ROOM on GURU_LESSON (ROOM_ID);
