alter table GURU_SCHOOL_CLASS add column IR_TECH_ID varchar(255) ^
update GURU_SCHOOL_CLASS set IR_TECH_ID = '' where IR_TECH_ID is null ;
alter table GURU_SCHOOL_CLASS alter column IR_TECH_ID set not null ;
