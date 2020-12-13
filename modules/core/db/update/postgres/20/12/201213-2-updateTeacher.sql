alter table GURU_TEACHER rename column organization_id to organization_id__u04843 ;
alter table GURU_TEACHER alter column organization_id__u04843 drop not null ;
alter table GURU_TEACHER drop constraint FK_GURU_TEACHER_ON_ORGANIZATION ;
drop index IDX_GURU_TEACHER_ON_ORGANIZATION ;
