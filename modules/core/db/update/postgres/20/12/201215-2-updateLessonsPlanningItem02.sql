-- update GURU_LESSONS_PLANNING_ITEM set GROUP_OF_LEARNING_ID = <default_value> where GROUP_OF_LEARNING_ID is null ;
alter table GURU_LESSONS_PLANNING_ITEM alter column GROUP_OF_LEARNING_ID set not null ;
