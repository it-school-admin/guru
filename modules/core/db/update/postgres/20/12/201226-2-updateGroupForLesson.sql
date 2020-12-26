alter table GURU_GROUP_FOR_LESSON rename column ir_tech_count_student to ir_tech_count_student__u18680 ;
alter table GURU_GROUP_FOR_LESSON rename column sub_group_name to sub_group_name__u33517 ;
alter table GURU_GROUP_FOR_LESSON add column OWN_NAME varchar(255) ;
alter table GURU_GROUP_FOR_LESSON add column COUNT_STUDENT integer ;
