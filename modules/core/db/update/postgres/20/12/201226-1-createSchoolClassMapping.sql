create table GURU_SCHOOL_CLASS_MAPPING (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHOOL_CLASS_ID uuid not null,
    THIRD_PARTY_SYSTEM_ID uuid not null,
    OUTER_ID integer not null,
    --
    primary key (ID)
);