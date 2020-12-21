alter table GURU_LESSON rename column caption_for_calendar to caption_for_calendar__u85708 ;
alter table GURU_LESSON alter column caption_for_calendar__u85708 drop not null ;
