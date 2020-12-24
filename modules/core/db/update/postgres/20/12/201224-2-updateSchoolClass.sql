alter table GURU_SCHOOL_CLASS add column IS_IN_DISTANT boolean ^
update GURU_SCHOOL_CLASS set IS_IN_DISTANT = false where IS_IN_DISTANT is null ;
alter table GURU_SCHOOL_CLASS alter column IS_IN_DISTANT set not null ;
