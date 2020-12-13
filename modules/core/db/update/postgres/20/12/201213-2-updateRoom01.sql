alter table GURU_ROOM add constraint FK_GURU_ROOM_ON_ROOM_BLOCK foreign key (ROOM_BLOCK_ID) references GURU_BLOCK(ID);
create index IDX_GURU_ROOM_ON_ROOM_BLOCK on GURU_ROOM (ROOM_BLOCK_ID);
