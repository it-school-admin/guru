-- begin GURU_SESSION
create table GURU_SESSION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOPIC varchar(255) not null,
    SPEAKER_ID varchar(36) not null,
    START_TIME timestamp not null,
    DURATION integer not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end GURU_SESSION
-- begin GURU_SPEAKER
create table GURU_SPEAKER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SPEAKER_NAME varchar(255) not null,
    SPEAKER_SURNAME varchar(255),
    SPEAKER_EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end GURU_SPEAKER
