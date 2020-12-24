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
    END_DATE varchar(255) not null,
    --
    primary key (ID)
);