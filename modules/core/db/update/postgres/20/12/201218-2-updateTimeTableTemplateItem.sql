alter table GURU_TIME_TABLE_TEMPLATE_ITEM rename column day_of_week to day_of_week__u12899 ;
alter table GURU_TIME_TABLE_TEMPLATE_ITEM alter column day_of_week__u12899 drop not null ;
