alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP foreign key (PARENT_GROUP_ID) references GURU_GROUP_FOR_LESSON(ID);
create index IDX_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP on GURU_GROUP_FOR_LESSON (PARENT_GROUP_ID);
