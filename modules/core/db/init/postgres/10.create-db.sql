-- begin GURU_TEACHER
create table GURU_TEACHER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEACHER_NAME varchar(255) not null,
    TEACHER_SECOND_NAME varchar(255) not null,
    TEACHER_FAMILY_NAME varchar(255) not null,
    TEACHER_EMAIL varchar(255),
    IR_TECH_ID integer,
    --
    primary key (ID)
)^
-- end GURU_TEACHER
-- begin GURU_SCHOOL_CLASS
create table GURU_SCHOOL_CLASS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLASS_NAME varchar(255) not null,
    CLASS_LEVEL integer not null,
    CLASS_EMAIL varchar(255),
    MAIN_LESSONS_GRID_TYPE_ID uuid,
    MAIN_TEACHER_ID uuid,
    DESCRIPTION varchar(255),
    STUDENT_COUNT integer,
    GIRLS_COUNT integer,
    BOYS_COUNT integer,
    IR_TECH_ID integer not null,
    --
    primary key (ID)
)^
-- end GURU_SCHOOL_CLASS
-- begin GURU_CLASS_LETTER
create table GURU_CLASS_LETTER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LETTER char not null,
    --
    primary key (ID)
)^
-- end GURU_CLASS_LETTER

-- begin GURU_EDUCATIONAL_PERIODS
create table GURU_EDUCATIONAL_PERIODS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PERIOD_NAME varchar(255) not null,
    EDUCATIONAL_YEAR varchar(255),
    --
    primary key (ID)
)^
-- end GURU_EDUCATIONAL_PERIODS

-- begin GURU_LESSON
create table GURU_LESSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STUDY_GROUP_ID uuid not null,
    IS_DISTANT boolean not null,
    SUBJECT_ID uuid,
    TEACHER_ID uuid,
    START_TIME varchar(255) not null,
    END_TIME varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_LESSON
-- begin GURU_LESSONS_PLANNING_ITEM
create table GURU_LESSONS_PLANNING_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GROUP_OF_LEARNING_ID uuid,
    HOURS_PER_WEEK varchar(255) not null,
    IR_TECH_ID integer,
    --
    primary key (ID)
)^
-- end GURU_LESSONS_PLANNING_ITEM
-- begin GURU_LESSONS_GRID
create table GURU_LESSONS_GRID (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LESSONS_GRID_TYPE_NAME varchar(255) not null,
    ORGANIZATION_ID uuid not null,
    --
    primary key (ID)
)^
-- end GURU_LESSONS_GRID
-- begin GURU_CLASS_LEVEL
create table GURU_CLASS_LEVEL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LEVEL_ integer not null,
    --
    primary key (ID)
)^
-- end GURU_CLASS_LEVEL
-- begin GURU_EDUCTAIONAL_YEAR
create table GURU_EDUCTAIONAL_YEAR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    START_DATE timestamp not null,
    END_DATE timestamp not null,
    --
    primary key (ID)
)^
-- end GURU_EDUCTAIONAL_YEAR
-- begin GURU_SCHOOL
create table GURU_SCHOOL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORGANIZATION_SHORT_NAME varchar(255) not null,
    PARENT_ORGANIZATION_ID uuid,
    ORGANIZATION_COUNTRY varchar(255),
    ORGANIZATION_LONG_NAME varchar(255) not null,
    ORGANIZATION_DOMAIN varchar(255),
    --
    primary key (ID)
)^
-- end GURU_SCHOOL
-- begin GURU_SUBJECT
create table GURU_SUBJECT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SUBJECT_NAME varchar(255),
    IR_TECH_ID integer,
    SHORTENED_NAME varchar(255),
    PARENT_SUBJECT_ID uuid,
    --
    primary key (ID)
)^
-- end GURU_SUBJECT
-- begin GURU_LESSONS_GRID_FOR_CLASS_PER_DAY_OF_WEEK
create table GURU_LESSONS_GRID_FOR_CLASS_PER_DAY_OF_WEEK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end GURU_LESSONS_GRID_FOR_CLASS_PER_DAY_OF_WEEK
-- begin GURU_GROUP_FOR_LESSON
create table GURU_GROUP_FOR_LESSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHOOL_CLASS_ID uuid not null,
    SUBJECT_ID uuid,
    IS_FULL_CLASS_GROUP boolean,
    PARENT_GROUP_ID uuid,
    SUB_GROUP_NAME varchar(255),
    TEACHER_ID uuid,
    GROUP_EMAIL varchar(255),
    GROUP_TEAMS_TEAM varchar(255),
    GROUP_IR_TECH_ID integer,
    GROUP_IR_TECH_NAME varchar(255),
    --
    primary key (ID)
)^
-- end GURU_GROUP_FOR_LESSON
-- begin GURU_LESSONS_GRID_TYPE_ITEM
create table GURU_LESSONS_GRID_TYPE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LESSON_NUMBER integer not null,
    LESSON_START_TIME timestamp not null,
    LESSON_END_TIME varchar(255),
    GRID_TYPE varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_LESSONS_GRID_TYPE_ITEM
-- begin GURU_TIME_TABLE_TEMPLATE_ITEM
create table GURU_TIME_TABLE_TEMPLATE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TIME_TABLE_TEMPLATE_ID uuid,
    SUBJECT_ID uuid not null,
    GROUP_FOR_LESSON_ID uuid not null,
    TIME_START timestamp not null,
    TIME_END timestamp not null,
    IR_TECH_ID integer,
    --
    primary key (ID)
)^
-- end GURU_TIME_TABLE_TEMPLATE_ITEM
-- begin GURU_TIME_TABLE_TEMPLATE
create table GURU_TIME_TABLE_TEMPLATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHOOL_CLASS_ID uuid not null,
    EDUCATIONAL_YEAR_ID uuid not null,
    SCHEDULE_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_TIME_TABLE_TEMPLATE
-- begin GURU_TIME_TABLE_IMPORT
create table GURU_TIME_TABLE_IMPORT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IMPORT_TIME timestamp not null,
    IMPORT_XML_DATA text not null,
    --
    primary key (ID)
)^
-- end GURU_TIME_TABLE_IMPORT
-- begin GURU_ROOM
create table GURU_ROOM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ROOM_NAME varchar(255) not null,
    ROOM_BLOCK_ID uuid,
    ROOM_FLOOR varchar(255),
    ROOM_SEATS_AMOUNT integer,
    IR_TEH_ID integer,
    --
    primary key (ID)
)^
-- end GURU_ROOM
-- begin GURU_BLOCK
create table GURU_BLOCK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BLOCK_NAME varchar(255) not null,
    BLOCK_GEO_POINT varchar(255),
    BLOCK_ADDRESS varchar(255),
    --
    primary key (ID)
)^
-- end GURU_BLOCK
