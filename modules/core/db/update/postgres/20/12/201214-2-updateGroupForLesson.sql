alter table GURU_GROUP_FOR_LESSON rename column teams_team to teams_team__u98985 ;
alter table GURU_GROUP_FOR_LESSON rename column email to email__u10959 ;
alter table GURU_GROUP_FOR_LESSON add column GROUP_TEAMS_TEAM varchar(255) ;
alter table GURU_GROUP_FOR_LESSON add column GROUP_IR_TECH_NAME varchar(255) ;
alter table GURU_GROUP_FOR_LESSON add column IS_FULL_CLASS_GROUP boolean ;
alter table GURU_GROUP_FOR_LESSON add column GROUP_IR_TECH_ID varchar(255) ;
alter table GURU_GROUP_FOR_LESSON add column GROUP_EMAIL varchar(255) ;
