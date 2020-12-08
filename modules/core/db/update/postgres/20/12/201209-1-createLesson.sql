create table GURU_LESSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STUDY_GROUP_ID uuid not null,
    SUBJECT_ID uuid,
    TEACHER_ID uuid,
    START_TIME varchar(255) not null,
    END_TIME varchar(255) not null,
    --
    primary key (ID)
);