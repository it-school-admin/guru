create table GURU_LESSONS_GRID_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GRID_TYPE_ID uuid not null,
    LESSON_START_TIME time not null,
    LESSON_END_TIME time not null,
    IR_TECH_SHIFT integer,
    IR_TECH_ID integer,
    --
    primary key (ID)
);