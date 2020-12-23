alter table GURU_LESSONS_GRID_ITEM rename column ir_tech_id to ir_tech_id__u81165 ;
alter table GURU_LESSONS_GRID_ITEM rename column ir_tech_shift to ir_tech_shift__u16660 ;
alter table GURU_LESSONS_GRID_ITEM rename column lesson_end_time to lesson_end_time__u50041 ;
alter table GURU_LESSONS_GRID_ITEM alter column lesson_end_time__u50041 drop not null ;
alter table GURU_LESSONS_GRID_ITEM add column LESSON_NUMBER integer ^
update GURU_LESSONS_GRID_ITEM set LESSON_NUMBER = 0 where LESSON_NUMBER is null ;
alter table GURU_LESSONS_GRID_ITEM alter column LESSON_NUMBER set not null ;
