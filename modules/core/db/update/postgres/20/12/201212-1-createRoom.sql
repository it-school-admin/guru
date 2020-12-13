create table GURU_ROOM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ROOM_NAME varchar(255) not null,
    IR_TEH_ID varchar(255),
    EDUCTAIONAL_ORGANIZATION_ID uuid not null,
    --
    primary key (ID)
);