-- begin GURU_SCHOOL_CLASS
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_CLASS_LEVEL foreign key (CLASS_LEVEL_ID) references GURU_CLASS_LEVEL(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_CLASS_LETTER foreign key (CLASS_LETTER_ID) references GURU_CLASS_LETTER(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_EDUCATIONAL_YEAR foreign key (EDUCATIONAL_YEAR_ID) references GURU_EDUCTAIONAL_YEAR(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_MAIN_LESSONS_GRID_TYPE foreign key (MAIN_LESSONS_GRID_TYPE_ID) references GURU_LESSONS_GRID(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_ORGANIZATION foreign key (ORGANIZATION_ID) references GURU_SCHOOL(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_MAIN_TEACHER foreign key (MAIN_TEACHER_ID) references GURU_TEACHER(ID)^
create unique index IDX_GURU_SCHOOL_CLASS_UK_CLASS_EMAIL on GURU_SCHOOL_CLASS (CLASS_EMAIL) where DELETE_TS is null ^
create index IDX_GURU_SCHOOL_CLASS_ON_CLASS_LEVEL on GURU_SCHOOL_CLASS (CLASS_LEVEL_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_CLASS_LETTER on GURU_SCHOOL_CLASS (CLASS_LETTER_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_EDUCATIONAL_YEAR on GURU_SCHOOL_CLASS (EDUCATIONAL_YEAR_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_MAIN_LESSONS_GRID_TYPE on GURU_SCHOOL_CLASS (MAIN_LESSONS_GRID_TYPE_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_ORGANIZATION on GURU_SCHOOL_CLASS (ORGANIZATION_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_MAIN_TEACHER on GURU_SCHOOL_CLASS (MAIN_TEACHER_ID)^
-- end GURU_SCHOOL_CLASS
-- begin GURU_CLASS_LETTER
create unique index IDX_GURU_CLASS_LETTER_UK_LETTER on GURU_CLASS_LETTER (LETTER) where DELETE_TS is null ^
-- end GURU_CLASS_LETTER
-- begin GURU_LESSON
alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_STUDY_GROUP foreign key (STUDY_GROUP_ID) references GURU_GROUP_FOR_LESSON(ID)^
alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_LESSONS_PLANNING_ITEM(ID)^
alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_TEACHER foreign key (TEACHER_ID) references GURU_TEACHER(ID)^
create index IDX_GURU_LESSON_ON_STUDY_GROUP on GURU_LESSON (STUDY_GROUP_ID)^
create index IDX_GURU_LESSON_ON_SUBJECT on GURU_LESSON (SUBJECT_ID)^
create index IDX_GURU_LESSON_ON_TEACHER on GURU_LESSON (TEACHER_ID)^
-- end GURU_LESSON
-- begin GURU_LESSONS_PLANNING_ITEM
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_GROUP_OF_LEARNING foreign key (GROUP_OF_LEARNING_ID) references GURU_GROUP_FOR_LESSON(ID)^
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID)^
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_EDUCATIONAL_PERIOD foreign key (EDUCATIONAL_PERIOD_ID) references GURU_EDUCATIONAL_PERIODS(ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_GROUP_OF_LEARNING on GURU_LESSONS_PLANNING_ITEM (GROUP_OF_LEARNING_ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT on GURU_LESSONS_PLANNING_ITEM (SUBJECT_ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_EDUCATIONAL_PERIOD on GURU_LESSONS_PLANNING_ITEM (EDUCATIONAL_PERIOD_ID)^
-- end GURU_LESSONS_PLANNING_ITEM
-- begin GURU_LESSONS_GRID
alter table GURU_LESSONS_GRID add constraint FK_GURU_LESSONS_GRID_ON_ORGANIZATION foreign key (ORGANIZATION_ID) references GURU_SCHOOL(ID)^
create index IDX_GURU_LESSONS_GRID_ON_ORGANIZATION on GURU_LESSONS_GRID (ORGANIZATION_ID)^
-- end GURU_LESSONS_GRID
-- begin GURU_CLASS_LEVEL
create unique index IDX_GURU_CLASS_LEVEL_UK_LEVEL_ on GURU_CLASS_LEVEL (LEVEL_) where DELETE_TS is null ^
-- end GURU_CLASS_LEVEL
-- begin GURU_EDUCTAIONAL_YEAR
create unique index IDX_GURU_EDUCTAIONAL_YEAR_UK_NAME on GURU_EDUCTAIONAL_YEAR (NAME) where DELETE_TS is null ^
-- end GURU_EDUCTAIONAL_YEAR
-- begin GURU_SCHOOL
alter table GURU_SCHOOL add constraint FK_GURU_SCHOOL_ON_PARENT_ORGANIZATION foreign key (PARENT_ORGANIZATION_ID) references GURU_SCHOOL(ID)^
create unique index IDX_GURU_SCHOOL_UK_ORGANIZATION_SHORT_NAME on GURU_SCHOOL (ORGANIZATION_SHORT_NAME) where DELETE_TS is null ^
create index IDX_GURU_SCHOOL_ON_PARENT_ORGANIZATION on GURU_SCHOOL (PARENT_ORGANIZATION_ID)^
-- end GURU_SCHOOL
-- begin GURU_TEACHER
alter table GURU_TEACHER add constraint FK_GURU_TEACHER_ON_ORGANIZATION foreign key (ORGANIZATION_ID) references GURU_SCHOOL(ID)^
create index IDX_GURU_TEACHER_ON_ORGANIZATION on GURU_TEACHER (ORGANIZATION_ID)^
-- end GURU_TEACHER
-- begin GURU_GROUP_FOR_LESSON
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_SCHOOL_CLASS foreign key (SCHOOL_CLASS_ID) references GURU_SCHOOL_CLASS(ID)^
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID)^
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_TEACHER foreign key (TEACHER_ID) references GURU_TEACHER(ID)^
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP foreign key (PARENT_GROUP_ID) references GURU_GROUP_FOR_LESSON(ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_SCHOOL_CLASS on GURU_GROUP_FOR_LESSON (SCHOOL_CLASS_ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_SUBJECT on GURU_GROUP_FOR_LESSON (SUBJECT_ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_TEACHER on GURU_GROUP_FOR_LESSON (TEACHER_ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP on GURU_GROUP_FOR_LESSON (PARENT_GROUP_ID)^
-- end GURU_GROUP_FOR_LESSON
