create table GURU_SESSION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOPIC varchar(255) not null,
    SPEAKER_ID uuid not null,
    START_TIME timestamp not null,
    DURATION integer not null,
    DESCRIPTION text,
    --
    primary key (ID)
);