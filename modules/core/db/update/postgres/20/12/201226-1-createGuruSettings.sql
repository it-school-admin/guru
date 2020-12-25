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
);