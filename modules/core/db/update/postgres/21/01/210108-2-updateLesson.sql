alter table GURU_LESSON rename column home_task_description to home_task_description__u95471 ;
alter table GURU_LESSON rename column tools_description to tools_description__u51434 ;
alter table GURU_LESSON rename column topic_of_the_lesson to topic_of_the_lesson__u03337 ;
alter table GURU_LESSON rename column week_id to week_id__u62822 ;
alter table GURU_LESSON alter column week_id__u62822 drop not null ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_WEEK ;
drop index IDX_GURU_LESSON_ON_WEEK ;
alter table GURU_LESSON rename column teacher_on_the_fly_id to teacher_on_the_fly_id__u18099 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_TEACHER_ON_THE_FLY ;
drop index IDX_GURU_LESSON_ON_TEACHER_ON_THE_FLY ;
alter table GURU_LESSON rename column subject_on_the_fly_id to subject_on_the_fly_id__u49512 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_SUBJECT_ON_THE_FLY ;
drop index IDX_GURU_LESSON_ON_SUBJECT_ON_THE_FLY ;
alter table GURU_LESSON rename column group_on_the_fly_id to group_on_the_fly_id__u87154 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_GROUP_ON_THE_FLY ;
drop index IDX_GURU_LESSON_ON_GROUP_ON_THE_FLY ;
alter table GURU_LESSON rename column planning_item_id to planning_item_id__u62108 ;
alter table GURU_LESSON drop constraint FK_GURU_LESSON_ON_PLANNING_ITEM ;
drop index IDX_GURU_LESSON_ON_PLANNING_ITEM ;
