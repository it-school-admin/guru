alter table GURU_LESSONS_PLANNING_ITEM rename column educational_period_id to educational_period_id__u25199 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column educational_period_id__u25199 drop not null ;
alter table GURU_LESSONS_PLANNING_ITEM drop constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_EDUCATIONAL_PERIOD ;
drop index IDX_GURU_LESSONS_PLANNING_ITEM_ON_EDUCATIONAL_PERIOD ;
alter table GURU_LESSONS_PLANNING_ITEM rename column school_class to school_class__u91603 ;
alter table GURU_LESSONS_PLANNING_ITEM alter column school_class__u91603 drop not null ;
-- alter table GURU_LESSONS_PLANNING_ITEM add column SCHOOL_CLASS_ID uuid ^
-- update GURU_LESSONS_PLANNING_ITEM set SCHOOL_CLASS_ID = <default_value> ;
-- alter table GURU_LESSONS_PLANNING_ITEM alter column SCHOOL_CLASS_ID set not null ;
alter table GURU_LESSONS_PLANNING_ITEM add column SCHOOL_CLASS_ID uuid not null ;
