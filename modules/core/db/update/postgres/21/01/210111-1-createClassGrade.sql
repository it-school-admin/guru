create table GURU_CLASS_GRADE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GRADE_NUMBER integer not null,
    PLANNING_TYPE integer not null,
    --
    primary key (ID)
);