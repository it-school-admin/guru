create unique index IDX_GURU_WEEK_DAY_UK_DAY_NUMBER on GURU_WEEK_DAY (DAY_NUMBER) where DELETE_TS is null ;
create unique index IDX_GURU_WEEK_DAY_UK_DAY_NAME on GURU_WEEK_DAY (DAY_NAME) where DELETE_TS is null ;
