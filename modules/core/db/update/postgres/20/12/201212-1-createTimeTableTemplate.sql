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
);