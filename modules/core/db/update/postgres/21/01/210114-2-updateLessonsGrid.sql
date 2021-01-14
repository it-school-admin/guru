alter table GURU_LESSONS_GRID add column STUDY_DAYS_AMOUNT integer ^
update GURU_LESSONS_GRID set STUDY_DAYS_AMOUNT = 0 where STUDY_DAYS_AMOUNT is null ;
alter table GURU_LESSONS_GRID alter column STUDY_DAYS_AMOUNT set not null ;
