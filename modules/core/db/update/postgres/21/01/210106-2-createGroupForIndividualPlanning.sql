alter table GURU_GROUP_FOR_INDIVIDUAL_PLANNING add constraint FK_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID);
create index IDX_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT on GURU_GROUP_FOR_INDIVIDUAL_PLANNING (SUBJECT_ID);
