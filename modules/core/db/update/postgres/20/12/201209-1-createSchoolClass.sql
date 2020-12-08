create table GURU_SCHOOL_CLASS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLASS_LEVEL_ID uuid not null,
    CLASS_LETTER_ID uuid not null,
    EDUCATIONAL_YEAR_ID uuid not null,
    CLASS_EMAIL varchar(255) not null,
    MAIN_LESSONS_GRID_TYPE_ID uuid not null,
    ORGANIZATION_ID uuid not null,
    MAIN_TEACHER_ID uuid not null,
    DESCRIPTION varchar(255),
    --
    primary key (ID)
);