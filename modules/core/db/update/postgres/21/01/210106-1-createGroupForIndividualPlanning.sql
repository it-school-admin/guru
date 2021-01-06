create table GURU_GROUP_FOR_INDIVIDUAL_PLANNING (
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
    SUBJECT_ID uuid not null,
    STUDENTS_COUNT integer,
    --
    primary key (ID)
);