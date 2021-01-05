alter table GURU_GROUP_FOR_LESSON rename column group_ir_tech_name to group_ir_tech_name__u31734 ;
alter table GURU_GROUP_FOR_LESSON rename column teacher_id to teacher_id__u88634 ;
alter table GURU_GROUP_FOR_LESSON drop constraint FK_GURU_GROUP_FOR_LESSON_ON_TEACHER ;
drop index IDX_GURU_GROUP_FOR_LESSON_ON_TEACHER ;
alter table GURU_GROUP_FOR_LESSON rename column subject_id to subject_id__u22689 ;
alter table GURU_GROUP_FOR_LESSON drop constraint FK_GURU_GROUP_FOR_LESSON_ON_SUBJECT ;
drop index IDX_GURU_GROUP_FOR_LESSON_ON_SUBJECT ;
alter table GURU_GROUP_FOR_LESSON rename column is_full_class_group to is_full_class_group__u96968 ;
