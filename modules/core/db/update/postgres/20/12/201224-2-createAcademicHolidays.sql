alter table GURU_ACADEMIC_HOLIDAYS add constraint FK_GURU_ACADEMIC_HOLIDAYS_ON_PERIOD foreign key (PERIOD_ID) references GURU_EDUCATIONAL_PERIOD(ID);
create index IDX_GURU_ACADEMIC_HOLIDAYS_ON_PERIOD on GURU_ACADEMIC_HOLIDAYS (PERIOD_ID);
