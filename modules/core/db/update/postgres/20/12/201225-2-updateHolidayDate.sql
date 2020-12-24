alter table GURU_HOLIDAY_DATE add column DATE_CHANGE_TYPE integer ^
update GURU_HOLIDAY_DATE set DATE_CHANGE_TYPE = 10 where DATE_CHANGE_TYPE is null ;
alter table GURU_HOLIDAY_DATE alter column DATE_CHANGE_TYPE set not null ;
