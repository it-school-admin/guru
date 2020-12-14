alter table GURU_GROUP_FOR_LESSON rename column group_name to group_name__u47029 ;
alter table GURU_GROUP_FOR_LESSON alter column group_name__u47029 drop not null ;
alter table GURU_GROUP_FOR_LESSON add column SUB_GROUP_NAME varchar(255) ;
