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
    CLASS_LEVEL integer not null,
    CLASS_LETTER char not null,
    CLASS_EMAIL varchar(255),
    MAIN_LESSONS_GRID_TYPE_ID uuid,
    MAIN_TEACHER_ID uuid not null,
    STUDENT_COUNT integer,
    SHIFT integer,
    IS_IN_DISTANT boolean not null,
    --
    primary key (ID)
)^
-- end GURU_SCHOOL_CLASS

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
    PLANNING_ITEM_ID uuid,
    START_TIME timestamp not null,
    DURATION integer not null,
    GROUP_ON_THE_FLY_ID uuid,
    SUBJECT_ON_THE_FLY_ID uuid,
    TEACHER_ON_THE_FLY_ID uuid,
    IS_DISTANT boolean not null,
    WEEK_ID uuid not null,
    ROOM_ID uuid,
    TOPIC_OF_THE_LESSON text,
    TOOLS_DESCRIPTION text,
    HOME_TASK_DESCRIPTION text,
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
    GROUP_OF_LEARNING_ID uuid not null,
    HOURS_PER_WEEK integer not null,
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
    DEFAULT_LESSON_TIME integer not null,
    SHIFT integer,
    --
    primary key (ID)
)^
-- end GURU_LESSONS_GRID

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
    IS_FULL_CLASS_GROUP boolean,
    PARENT_GROUP_ID uuid,
    SUBJECT_ID uuid,
    OWN_NAME varchar(255),
    TEACHER_ID uuid,
    GROUP_EMAIL varchar(255),
    GROUP_TEAMS_TEAM varchar(255),
    GROUP_IR_TECH_ID integer,
    COUNT_STUDENT integer,
    GROUP_IR_TECH_NAME varchar(255),
    --
    primary key (ID)
)^
-- end GURU_GROUP_FOR_LESSON

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
    NUMBER_OF_LESSON integer not null,
    ROOM_ID uuid,
    WEEK_DAY integer not null,
    PLANNING_ITEM_ID uuid,
    --
    primary key (ID)
)^
-- end GURU_TIME_TABLE_TEMPLATE_ITEM

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
-- begin GURU_LESSONS_GRID_ITEM
create table GURU_LESSONS_GRID_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GRID_TYPE_ID uuid not null,
    LESSON_NUMBER integer not null,
    LESSON_START_TIME time not null,
    --
    primary key (ID)
)^
-- end GURU_LESSONS_GRID_ITEM

-- begin GURU_EDUCATIONAL_YEAR
create table GURU_EDUCATIONAL_YEAR (
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
    START_DATE date not null,
    END_DATE date not null,
    --
    primary key (ID)
)^
-- end GURU_EDUCATIONAL_YEAR
-- begin GURU_WEEK
create table GURU_WEEK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    WEEK_NUMBER integer not null,
    START_DATE date not null,
    END_DATE date not null,
    EDUCATIONAL_YEAR_ID uuid not null,
    --
    primary key (ID)
)^
-- end GURU_WEEK
-- begin GURU_HOLIDAY
create table GURU_HOLIDAY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    HOLIDAY_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_HOLIDAY
-- begin GURU_HOLIDAY_DATE
create table GURU_HOLIDAY_DATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    HOLIDAY_ID uuid not null,
    HOLIDAY_DATE date not null,
    DATE_CHANGE_TYPE integer not null,
    TRANSFER_LESSONS_FROM date,
    --
    primary key (ID)
)^
-- end GURU_HOLIDAY_DATE
-- begin GURU_EDUCATIONAL_PERIOD
create table GURU_EDUCATIONAL_PERIOD (
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
    EDUCATIONAL_YEAR_ID uuid not null,
    START_DATE date not null,
    END_DATE date not null,
    --
    primary key (ID)
)^
-- end GURU_EDUCATIONAL_PERIOD
-- begin GURU_ACADEMIC_HOLIDAYS
create table GURU_ACADEMIC_HOLIDAYS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    HOLIDAYS_NAME varchar(255) not null,
    PERIOD_ID uuid not null,
    START_DATE date not null,
    END_DATE date not null,
    --
    primary key (ID)
)^
-- end GURU_ACADEMIC_HOLIDAYS
-- begin GURU_GURU_SETTINGS
create table GURU_GURU_SETTINGS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SETTING_KEY varchar(255) not null,
    STRING_VALUE varchar(255),
    INTEGER_VALUE integer,
    DATE_VALUE date,
    TIME_VALUE time,
    DATE_TIME_VALUE timestamp,
    TEXT_VALUE text,
    OBJECT_VALUE uuid,
    --
    primary key (ID)
)^
-- end GURU_GURU_SETTINGS
-- begin GURU_SCHOOL_CLASS_MAPPING
create table GURU_SCHOOL_CLASS_MAPPING (
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
    THIRD_PARTY_SYSTEM_ID uuid not null,
    OUTER_ID integer not null,
    --
    primary key (ID)
)^
-- end GURU_SCHOOL_CLASS_MAPPING
-- begin GURU_THIRD_PARTY_SYSTEM
create table GURU_THIRD_PARTY_SYSTEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SYSTEM_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_THIRD_PARTY_SYSTEM
