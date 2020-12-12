create table GURU_TIME_TABLE_IMPORT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IMPORT_TIME timestamp not null,
    IMPORT_FILE varchar(255) not null,
    --
    primary key (ID)
);