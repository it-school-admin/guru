alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column planning_item to planning_item__u08427 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column PLANNING_ITEM_ID uuid ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM add column ROOM_ID uuid ;
