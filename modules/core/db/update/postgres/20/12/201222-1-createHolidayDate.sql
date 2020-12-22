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
    --
    primary key (ID)
);