-- begin GURU_SCHOOL_CLASS
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_MAIN_LESSONS_GRID_TYPE foreign key (MAIN_LESSONS_GRID_TYPE_ID) references GURU_LESSONS_GRID(ID)^
alter table GURU_SCHOOL_CLASS add constraint FK_GURU_SCHOOL_CLASS_ON_MAIN_TEACHER foreign key (MAIN_TEACHER_ID) references GURU_TEACHER(ID)^
create unique index IDX_GURU_SCHOOL_CLASS_UK_CLASS_EMAIL on GURU_SCHOOL_CLASS (CLASS_EMAIL) where DELETE_TS is null ^
create index IDX_GURU_SCHOOL_CLASS_ON_MAIN_LESSONS_GRID_TYPE on GURU_SCHOOL_CLASS (MAIN_LESSONS_GRID_TYPE_ID)^
create index IDX_GURU_SCHOOL_CLASS_ON_MAIN_TEACHER on GURU_SCHOOL_CLASS (MAIN_TEACHER_ID)^
-- end GURU_SCHOOL_CLASS

-- begin GURU_LESSON
alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_PLAN_ITEM foreign key (PLAN_ITEM_ID) references GURU_LESSONS_PLANNING_ITEM(ID)^
alter table GURU_LESSON add constraint FK_GURU_LESSON_ON_ROOM foreign key (ROOM_ID) references GURU_ROOM(ID)^
create index IDX_GURU_LESSON_ON_PLAN_ITEM on GURU_LESSON (PLAN_ITEM_ID)^
create index IDX_GURU_LESSON_ON_ROOM on GURU_LESSON (ROOM_ID)^
-- end GURU_LESSON
-- begin GURU_LESSONS_PLANNING_ITEM
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID)^
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_REGULAR_GROUP foreign key (REGULAR_GROUP_ID) references GURU_GROUP_FOR_LESSON(ID)^
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_INDIVIDUAL_PLAN_GROUP foreign key (INDIVIDUAL_PLAN_GROUP_ID) references GURU_GROUP_FOR_INDIVIDUAL_PLANNING(ID)^
alter table GURU_LESSONS_PLANNING_ITEM add constraint FK_GURU_LESSONS_PLANNING_ITEM_ON_TEACHER foreign key (TEACHER_ID) references GURU_TEACHER(ID)^
create unique index IDX_GURU_LESSONS_PLANNING_ITEM_UK_IR_TECH_ID on GURU_LESSONS_PLANNING_ITEM (IR_TECH_ID) where DELETE_TS is null ^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_SUBJECT on GURU_LESSONS_PLANNING_ITEM (SUBJECT_ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_REGULAR_GROUP on GURU_LESSONS_PLANNING_ITEM (REGULAR_GROUP_ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_INDIVIDUAL_PLAN_GROUP on GURU_LESSONS_PLANNING_ITEM (INDIVIDUAL_PLAN_GROUP_ID)^
create index IDX_GURU_LESSONS_PLANNING_ITEM_ON_TEACHER on GURU_LESSONS_PLANNING_ITEM (TEACHER_ID)^
-- end GURU_LESSONS_PLANNING_ITEM

-- begin GURU_SCHOOL
alter table GURU_SCHOOL add constraint FK_GURU_SCHOOL_ON_PARENT_ORGANIZATION foreign key (PARENT_ORGANIZATION_ID) references GURU_SCHOOL(ID)^
create unique index IDX_GURU_SCHOOL_UK_ORGANIZATION_SHORT_NAME on GURU_SCHOOL (ORGANIZATION_SHORT_NAME) where DELETE_TS is null ^
create index IDX_GURU_SCHOOL_ON_PARENT_ORGANIZATION on GURU_SCHOOL (PARENT_ORGANIZATION_ID)^
-- end GURU_SCHOOL
-- begin GURU_TEACHER
create unique index IDX_GURU_TEACHER_UK_IR_TECH_ID on GURU_TEACHER (IR_TECH_ID) where DELETE_TS is null ^
-- end GURU_TEACHER
-- begin GURU_GROUP_FOR_LESSON
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_SCHOOL_CLASS foreign key (SCHOOL_CLASS_ID) references GURU_SCHOOL_CLASS(ID)^
alter table GURU_GROUP_FOR_LESSON add constraint FK_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP foreign key (PARENT_GROUP_ID) references GURU_GROUP_FOR_LESSON(ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_SCHOOL_CLASS on GURU_GROUP_FOR_LESSON (SCHOOL_CLASS_ID)^
create index IDX_GURU_GROUP_FOR_LESSON_ON_PARENT_GROUP on GURU_GROUP_FOR_LESSON (PARENT_GROUP_ID)^
-- end GURU_GROUP_FOR_LESSON
-- begin GURU_SUBJECT
alter table GURU_SUBJECT add constraint FK_GURU_SUBJECT_ON_PARENT_SUBJECT foreign key (PARENT_SUBJECT_ID) references GURU_SUBJECT(ID)^
create unique index IDX_GURU_SUBJECT_UK_IR_TECH_ID on GURU_SUBJECT (IR_TECH_ID) where DELETE_TS is null ^
create index IDX_GURU_SUBJECT_ON_PARENT_SUBJECT on GURU_SUBJECT (PARENT_SUBJECT_ID)^
-- end GURU_SUBJECT
-- begin GURU_TIME_TABLE_TEMPLATE_ITEM
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_TIMETABLE_TEMPLATE foreign key (TIMETABLE_TEMPLATE_ID) references GURU_TIMETABLE_TEMPLATE(ID)^
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_PLANNING_ITEM foreign key (PLANNING_ITEM_ID) references GURU_LESSONS_PLANNING_ITEM(ID)^
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add constraint FK_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_ROOM foreign key (ROOM_ID) references GURU_ROOM(ID)^
create index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_TIMETABLE_TEMPLATE on GURU_TIME_TABLE_TEMPLATE_ITEM (TIMETABLE_TEMPLATE_ID)^
create index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_PLANNING_ITEM on GURU_TIME_TABLE_TEMPLATE_ITEM (PLANNING_ITEM_ID)^
create index IDX_GURU_TIME_TABLE_TEMPLATE_ITEM_ON_ROOM on GURU_TIME_TABLE_TEMPLATE_ITEM (ROOM_ID)^
-- end GURU_TIME_TABLE_TEMPLATE_ITEM

-- begin GURU_ROOM
alter table GURU_ROOM add constraint FK_GURU_ROOM_ON_ROOM_BLOCK foreign key (ROOM_BLOCK_ID) references GURU_BLOCK(ID)^
create index IDX_GURU_ROOM_ON_ROOM_BLOCK on GURU_ROOM (ROOM_BLOCK_ID)^
-- end GURU_ROOM
-- begin GURU_LESSONS_GRID_ITEM
alter table GURU_LESSONS_GRID_ITEM add constraint FK_GURU_LESSONS_GRID_ITEM_ON_GRID_TYPE foreign key (GRID_TYPE_ID) references GURU_LESSONS_GRID(ID)^
create index IDX_GURU_LESSONS_GRID_ITEM_ON_GRID_TYPE on GURU_LESSONS_GRID_ITEM (GRID_TYPE_ID)^
-- end GURU_LESSONS_GRID_ITEM

-- begin GURU_EDUCATIONAL_YEAR
create unique index IDX_GURU_EDUCATIONAL_YEAR_UK_NAME on GURU_EDUCATIONAL_YEAR (NAME) where DELETE_TS is null ^
-- end GURU_EDUCATIONAL_YEAR
-- begin GURU_HOLIDAY_DATE
alter table GURU_HOLIDAY_DATE add constraint FK_GURU_HOLIDAY_DATE_ON_HOLIDAY foreign key (HOLIDAY_ID) references GURU_HOLIDAY(ID)^
create index IDX_GURU_HOLIDAY_DATE_ON_HOLIDAY on GURU_HOLIDAY_DATE (HOLIDAY_ID)^
-- end GURU_HOLIDAY_DATE
-- begin GURU_EDUCATIONAL_PERIOD
alter table GURU_EDUCATIONAL_PERIOD add constraint FK_GURU_EDUCATIONAL_PERIOD_ON_EDUCATIONAL_YEAR foreign key (EDUCATIONAL_YEAR_ID) references GURU_EDUCATIONAL_YEAR(ID)^
create index IDX_GURU_EDUCATIONAL_PERIOD_ON_EDUCATIONAL_YEAR on GURU_EDUCATIONAL_PERIOD (EDUCATIONAL_YEAR_ID)^
-- end GURU_EDUCATIONAL_PERIOD
-- begin GURU_ACADEMIC_HOLIDAYS
alter table GURU_ACADEMIC_HOLIDAYS add constraint FK_GURU_ACADEMIC_HOLIDAYS_ON_PERIOD foreign key (PERIOD_ID) references GURU_EDUCATIONAL_PERIOD(ID)^
create index IDX_GURU_ACADEMIC_HOLIDAYS_ON_PERIOD on GURU_ACADEMIC_HOLIDAYS (PERIOD_ID)^
-- end GURU_ACADEMIC_HOLIDAYS
-- begin GURU_WEEK
alter table GURU_WEEK add constraint FK_GURU_WEEK_ON_EDUCATIONAL_YEAR foreign key (EDUCATIONAL_YEAR_ID) references GURU_EDUCATIONAL_YEAR(ID)^
create index IDX_GURU_WEEK_ON_EDUCATIONAL_YEAR on GURU_WEEK (EDUCATIONAL_YEAR_ID)^
-- end GURU_WEEK
-- begin GURU_SCHOOL_CLASS_MAPPING
alter table GURU_SCHOOL_CLASS_MAPPING add constraint FK_GURU_SCHOOL_CLASS_MAPPING_ON_SCHOOL_CLASS foreign key (SCHOOL_CLASS_ID) references GURU_SCHOOL_CLASS(ID)^
alter table GURU_SCHOOL_CLASS_MAPPING add constraint FK_GURU_SCHOOL_CLASS_MAPPING_ON_THIRD_PARTY_SYSTEM foreign key (THIRD_PARTY_SYSTEM_ID) references GURU_THIRD_PARTY_SYSTEM(ID)^
create index IDX_GURU_SCHOOL_CLASS_MAPPING_ON_SCHOOL_CLASS on GURU_SCHOOL_CLASS_MAPPING (SCHOOL_CLASS_ID)^
create index IDX_GURU_SCHOOL_CLASS_MAPPING_ON_THIRD_PARTY_SYSTEM on GURU_SCHOOL_CLASS_MAPPING (THIRD_PARTY_SYSTEM_ID)^
-- end GURU_SCHOOL_CLASS_MAPPING
-- begin GURU_GROUP_FOR_INDIVIDUAL_PLANNING
alter table GURU_GROUP_FOR_INDIVIDUAL_PLANNING add constraint FK_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT foreign key (SUBJECT_ID) references GURU_SUBJECT(ID)^
create index IDX_GURU_GROUP_FOR_INDIVIDUAL_PLANNING_ON_SUBJECT on GURU_GROUP_FOR_INDIVIDUAL_PLANNING (SUBJECT_ID)^
-- end GURU_GROUP_FOR_INDIVIDUAL_PLANNING
-- begin GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK
alter table GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK add constraint FK_GROFORINDPLASCHCLA_ON_GROUP_FOR_INDIVIDUAL_PLANNING foreign key (GROUP_FOR_INDIVIDUAL_PLANNING_ID) references GURU_GROUP_FOR_INDIVIDUAL_PLANNING(ID)^
alter table GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK add constraint FK_GROFORINDPLASCHCLA_ON_SCHOOL_CLASS foreign key (SCHOOL_CLASS_ID) references GURU_SCHOOL_CLASS(ID)^
-- end GURU_GROUP_FOR_INDIVIDUAL_PLANNING_SCHOOL_CLASS_LINK
