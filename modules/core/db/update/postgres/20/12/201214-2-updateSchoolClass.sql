alter table GURU_SCHOOL_CLASS rename column ir_tech_id to ir_tech_id__u46587 ;
alter table GURU_SCHOOL_CLASS alter column ir_tech_id__u46587 drop not null ;
alter table GURU_SCHOOL_CLASS rename column organization_id to organization_id__u69357 ;
alter table GURU_SCHOOL_CLASS alter column organization_id__u69357 drop not null ;
alter table GURU_SCHOOL_CLASS drop constraint FK_GURU_SCHOOL_CLASS_ON_ORGANIZATION ;
drop index IDX_GURU_SCHOOL_CLASS_ON_ORGANIZATION ;
alter table GURU_SCHOOL_CLASS rename column educational_year_id to educational_year_id__u08507 ;
alter table GURU_SCHOOL_CLASS alter column educational_year_id__u08507 drop not null ;
alter table GURU_SCHOOL_CLASS drop constraint FK_GURU_SCHOOL_CLASS_ON_EDUCATIONAL_YEAR ;
drop index IDX_GURU_SCHOOL_CLASS_ON_EDUCATIONAL_YEAR ;
alter table GURU_SCHOOL_CLASS rename column class_letter_id to class_letter_id__u62996 ;
alter table GURU_SCHOOL_CLASS alter column class_letter_id__u62996 drop not null ;
alter table GURU_SCHOOL_CLASS drop constraint FK_GURU_SCHOOL_CLASS_ON_CLASS_LETTER ;
drop index IDX_GURU_SCHOOL_CLASS_ON_CLASS_LETTER ;
alter table GURU_SCHOOL_CLASS rename column class_level_id to class_level_id__u71330 ;
alter table GURU_SCHOOL_CLASS alter column class_level_id__u71330 drop not null ;
alter table GURU_SCHOOL_CLASS drop constraint FK_GURU_SCHOOL_CLASS_ON_CLASS_LEVEL ;
drop index IDX_GURU_SCHOOL_CLASS_ON_CLASS_LEVEL ;
alter table GURU_SCHOOL_CLASS add column STUDENT_COUNT integer ;
alter table GURU_SCHOOL_CLASS add column BOYS_COUNT integer ;
alter table GURU_SCHOOL_CLASS add column CLASS_LEVEL integer ^
update GURU_SCHOOL_CLASS set CLASS_LEVEL = 0 where CLASS_LEVEL is null ;
alter table GURU_SCHOOL_CLASS alter column CLASS_LEVEL set not null ;
alter table GURU_SCHOOL_CLASS add column GIRLS_COUNT integer ;
-- alter table GURU_SCHOOL_CLASS add column CLASS_NAME varchar(255) ^
-- update GURU_SCHOOL_CLASS set CLASS_NAME = <default_value> ;
-- alter table GURU_SCHOOL_CLASS alter column CLASS_NAME set not null ;
alter table GURU_SCHOOL_CLASS add column CLASS_NAME varchar(255) ;
alter table GURU_SCHOOL_CLASS alter column CLASS_EMAIL drop not null ;
alter table GURU_SCHOOL_CLASS alter column MAIN_LESSONS_GRID_TYPE_ID drop not null ;
alter table GURU_SCHOOL_CLASS alter column MAIN_TEACHER_ID drop not null ;
alter table GURU_SCHOOL_CLASS add column IR_TECH_ID integer ^
update GURU_SCHOOL_CLASS set IR_TECH_ID = 0 where IR_TECH_ID is null ;
alter table GURU_SCHOOL_CLASS alter column IR_TECH_ID set not null ;
