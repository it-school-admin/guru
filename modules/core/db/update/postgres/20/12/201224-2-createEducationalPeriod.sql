alter table GURU_EDUCATIONAL_PERIOD add constraint FK_GURU_EDUCATIONAL_PERIOD_ON_EDUCATIONAL_YEAR foreign key (EDUCATIONAL_YEAR_ID) references GURU_EDUCATIONAL_YEAR(ID);
create index IDX_GURU_EDUCATIONAL_PERIOD_ON_EDUCATIONAL_YEAR on GURU_EDUCATIONAL_PERIOD (EDUCATIONAL_YEAR_ID);
