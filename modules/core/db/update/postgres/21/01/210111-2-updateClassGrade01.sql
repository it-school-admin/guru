alter table GURU_CLASS_GRADE add constraint FK_GURU_CLASS_GRADE_ON_LEVEL foreign key (LEVEL_ID) references GURU_STUDY_LEVEL(ID);
create index IDX_GURU_CLASS_GRADE_ON_LEVEL on GURU_CLASS_GRADE (LEVEL_ID);
