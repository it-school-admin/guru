alter table GURU_LESSONS_PLANNING_ITEM rename column school_class_id to school_class_id__u26127 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column school_class_id__u26127 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM drop constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_SCHOOL_CLASS ;
drop index IDX_GURU_LESSONS_PLANNING_ITEM_ON_SCHOOL_CLASS ;
alter table GURU_LESSONS_PLANNING_ITEM rename column subject_id to subject_id__u71521 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column subject_id__u71521 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM drop constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT ;
drop index IDX_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT ;
