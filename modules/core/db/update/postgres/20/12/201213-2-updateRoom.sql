alter table GURU_ROOM rename column eductaional_organization_id to eductaional_organization_id__u22996 ;
alter table GURU_ROOM alter column eductaional_organization_id__u22996 drop not null ;
alter table GURU_ROOM drop constraint FK_GURU_ROOM_ON_EDUCTAIONAL_ORGANIZATION ;
drop index IDX_GURU_ROOM_ON_EDUCTAIONAL_ORGANIZATION ;
alter table GURU_ROOM rename column ir_teh_id to ir_teh_id__u90028 ;
alter table GURU_ROOM add column ROOM_SEATS_AMOUNT integer ;
alter table GURU_ROOM add column ROOM_FLOOR varchar(255) ;
alter table GURU_ROOM add column ROOM_BLOCK_ID uuid ;
alter table GURU_ROOM add column IR_TEH_ID integer ;
