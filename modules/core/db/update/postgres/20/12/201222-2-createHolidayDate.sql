alter table GURU_HOLIDAY_DATE add constraint FK_GURU_HOLIDAY_DATE_ON_HOLIDAY foreign key (HOLIDAY_ID) references GURU_HOLIDAY(ID);
create index IDX_GURU_HOLIDAY_DATE_ON_HOLIDAY on GURU_HOLIDAY_DATE (HOLIDAY_ID);
