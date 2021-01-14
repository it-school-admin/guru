-- update GURU_SCHOOL_CLASS set GRADE_ID = <default_value> where GRADE_ID is null ;
alter table GURU_SCHOOL_CLASS alter column GRADE_ID set not null ;
