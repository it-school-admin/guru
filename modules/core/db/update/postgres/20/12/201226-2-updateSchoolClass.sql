alter table GURU_SCHOOL_CLASS rename column ir_tech_id to ir_tech_id__u53042 ;
alter table GURU_SCHOOL_CLASS alter column ir_tech_id__u53042 drop not null ;
alter table GURU_SCHOOL_CLASS rename column class_name to class_name__u41754 ;
alter table GURU_SCHOOL_CLASS alter column class_name__u41754 drop not null ;
alter table GURU_SCHOOL_CLASS rename column description to description__u27608 ;
alter table GURU_SCHOOL_CLASS add column CLASS_LETTER char ^
alter table GURU_SCHOOL_CLASS alter column CLASS_LETTER set not null ;
