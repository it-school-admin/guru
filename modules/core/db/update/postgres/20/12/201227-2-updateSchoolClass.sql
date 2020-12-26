-- update GURU_SCHOOL_CLASS set MAIN_TEACHER_ID = <default_value> where MAIN_TEACHER_ID is null ;
alter table GURU_SCHOOL_CLASS alter column MAIN_TEACHER_ID set not null ;
