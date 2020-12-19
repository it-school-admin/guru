alter table GURU_LESSON add column CAPTION_FOR_CALENDAR varchar(255) ^
update GURU_LESSON set CAPTION_FOR_CALENDAR = '' where CAPTION_FOR_CALENDAR is null ;
alter table GURU_LESSON alter column CAPTION_FOR_CALENDAR set not null ;
