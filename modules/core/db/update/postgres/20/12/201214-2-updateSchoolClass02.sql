-- update GURU_SCHOOL_CLASS set CLASS_NAME = <default_value> where CLASS_NAME is null ;
alter table GURU_SCHOOL_CLASS alter column CLASS_NAME set not null ;
