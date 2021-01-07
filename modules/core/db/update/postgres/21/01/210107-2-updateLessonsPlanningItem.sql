alter table GURU_LESSONS_PLANNING_ITEM rename column school_class_id to school_class_id__u04840 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column school_class_id__u04840 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM drop constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_SCHOOL_CLASS ;
drop index IDX_GURU_LESSONS_PLANNING_ITEM_ON_SCHOOL_CLASS ;
alter table GURU_LESSONS_PLANNING_ITEM add column REGULAR_GROUP_ID uuid ;
-- alter table GURU_LESSONS_PLANNING_ITEM add column TEACHER_ID uuid ^
-- update GURU_LESSONS_PLANNING_ITEM set TEACHER_ID = <default_value> ;
-- alter table GURU_LESSONS_PLANNING_ITEM alter column TEACHER_ID set not null ;
alter table GURU_LESSONS_PLANNING_ITEM add column TEACHER_ID uuid not null ;
