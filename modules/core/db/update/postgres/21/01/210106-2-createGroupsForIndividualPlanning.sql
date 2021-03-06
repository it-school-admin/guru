alter table GURU_GROUPS_FOR_INDIVIDUAL_PLANNING add constraint FK_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID);
alter table GURU_GROUPS_FOR_INDIVIDUAL_PLANNING add constraint FK_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_TEACHER foreign key (TEACHER_ID) references GURU_TEACHER(ID);
create index IDX_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT on GURU_GROUPS_FOR_INDIVIDUAL_PLANNING (SUBJECT_ID);
create index IDX_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_TEACHER on GURU_GROUPS_FOR_INDIVIDUAL_PLANNING (TEACHER_ID);
