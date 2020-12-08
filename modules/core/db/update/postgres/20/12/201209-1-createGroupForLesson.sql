create table GURU_GROUP_FOR_LESSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GROUP_NAME varchar(255) not null,
    SCHOOL_CLASS_ID uuid not null,
    SUBJECT_ID uuid,
    TEACHER_ID uuid not null,
    EMAIL varchar(255),
    TEAMS_TEAM varchar(255),
    --
    primary key (ID)
);