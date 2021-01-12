alter table GURU_GROUP_FOR_INDIVIDUAL_PLANNING add constraint FK_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_STUDY_PROFILE foreign key (STUDY_PROFILE_ID) references GURU_STUDY_PROFILE(ID);
create index IDX_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_STUDY_PROFILE on GURU_GROUP_FOR_INDIVIDUAL_PLANNING (STUDY_PROFILE_ID);