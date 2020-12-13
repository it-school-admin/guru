create table GURU_BLOCK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BLOCK_NAME varchar(255) not null,
    BLOCK_GEO_POINT varchar(255),
    BLOCK_ADDRESS varchar(255),
    --
    primary key (ID)
);