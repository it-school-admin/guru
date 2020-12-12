alter table GURU_LESSON add column IS_DISTANT boolean ^
update GURU_LESSON set IS_DISTANT = false where IS_DISTANT is null ;
alter table GURU_LESSON alter column IS_DISTANT set not null ;
