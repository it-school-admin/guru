alter table GURU_LESSON rename column home_task_desription to home_task_desription__u95215 ;
alter table GURU_LESSON add column HOME_TASK_DESCRIPTION text ;
alter table GURU_LESSON alter column TOOLS_DESCRIPTION set data type text ;
