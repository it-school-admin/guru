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
    WEEK_NUMBER integer,
    START_DATE date not null,
    END_DATE date not null,
    --
    primary key (ID)
);