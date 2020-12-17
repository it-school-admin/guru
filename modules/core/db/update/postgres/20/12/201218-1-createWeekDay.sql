create table GURU_WEEK_DAY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DAY_NUMBER varchar(255) not null,
    DAY_NAME varchar(255) not null,
    --
    primary key (ID)
);