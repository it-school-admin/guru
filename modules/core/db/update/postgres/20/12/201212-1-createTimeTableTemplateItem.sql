create table GURU_TIME_TABLE_TEMPLATE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TIME_TABLE_TEMPLATE_ID uuid,
    SUBJECT_ID uuid not null,
    GROUP_FOR_LESSON_ID uuid not null,
    TIME_START timestamp not null,
    TIME_END timestamp not null,
    --
    primary key (ID)
);