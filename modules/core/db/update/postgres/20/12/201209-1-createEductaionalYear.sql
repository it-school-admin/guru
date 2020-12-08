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
);