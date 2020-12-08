create table GURU_SCHOOL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORGANIZATION_SHORT_NAME varchar(255) not null,
    ORGANIZATION_COUNTRY varchar(255),
    ORGANIZATION_LONG_NAME varchar(255) not null,
    ORGANIZATION_DOMAIN varchar(255),
    --
    primary key (ID)
);