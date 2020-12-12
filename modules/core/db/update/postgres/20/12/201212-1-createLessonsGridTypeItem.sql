create table GURU_LESSONS_GRID_TYPE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LESSON_NUMBER integer not null,
    LESSON_START_TIME timestamp not null,
    LESSON_END_TIME varchar(255),
    GRID_TYPE varchar(255) not null,
    --
    primary key (ID)
);