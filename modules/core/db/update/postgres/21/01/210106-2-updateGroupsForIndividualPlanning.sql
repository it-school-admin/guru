alter table GURU_GROUPS_FOR_INDIVIDUAL_PLANNING rename column teacher_id to teacher_id__u37428 ;
alter table GURU_GROUPS_FOR_INDIVIDUAL_PLANNING alter column teacher_id__u37428 drop not null ;
alter table GURU_GROUPS_FOR_INDIVIDUAL_PLANNING drop constraint FK_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_TEACHER ;
drop index IDX_GURU_GROUPS_FOR_INDIVIDUAL_PLANNING_ON_TEACHER ;
