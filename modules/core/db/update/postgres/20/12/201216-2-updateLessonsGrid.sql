alter table GURU_LESSONS_GRID rename column organization_id to organization_id__u96194 ;
alter table GURU_LESSONS_GRID alter column organization_id__u96194 drop not null ;
alter table GURU_LESSONS_GRID drop constraint FK_GURU_LESSONS_GRID_ON_ORGANIZATION ;
drop index IDX_GURU_LESSONS_GRID_ON_ORGANIZATION ;
alter table GURU_LESSONS_GRID add column DEFAULT_LESSON_TIME integer ^
update GURU_LESSONS_GRID set DEFAULT_LESSON_TIME = 0 where DEFAULT_LESSON_TIME is null ;
alter table GURU_LESSONS_GRID alter column DEFAULT_LESSON_TIME set not null ;
