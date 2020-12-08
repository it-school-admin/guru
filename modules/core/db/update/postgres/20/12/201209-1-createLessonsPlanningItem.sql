create table GURU_LESSONS_PLANNING_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHOOL_CLASS varchar(255) not null,
    GROUP_OF_LEARNING_ID uuid,
    SUBJECT_ID uuid not null,
    HOURS_PER_WEEK varchar(255) not null,
    EDUCATIONAL_PERIOD_ID uuid not null,
    --
    primary key (ID)
);