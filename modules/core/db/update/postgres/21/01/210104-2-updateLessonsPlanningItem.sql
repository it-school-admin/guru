alter table GURU_LESSONS_PLANNING_ITEM rename column group_of_learning_id to group_of_learning_id__u53232 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column group_of_learning_id__u53232 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM drop constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_GROUP_OF_LEARNING ;
drop index IDX_GURU_LESSONS_PLANNING_ITEM_ON_GROUP_OF_LEARNING ;
-- alter table GURU_LESSONS_PLANNING_ITEM add column SUBJECT_ID uuid ^
-- update GURU_LESSONS_PLANNING_ITEM set SUBJECT_ID = <default_value> ;
-- alter table GURU_LESSONS_PLANNING_ITEM alter column SUBJECT_ID set not null ;
alter table GURU_LESSONS_PLANNING_ITEM add column SUBJECT_ID uuid not null ;
-- alter table GURU_LESSONS_PLANNING_ITEM add column SCHOOL_CLASS_ID uuid ^
-- update GURU_LESSONS_PLANNING_ITEM set SCHOOL_CLASS_ID = <default_value> ;
-- alter table GURU_LESSONS_PLANNING_ITEM alter column SCHOOL_CLASS_ID set not null ;
alter table GURU_LESSONS_PLANNING_ITEM add column SCHOOL_CLASS_ID uuid not null ;
