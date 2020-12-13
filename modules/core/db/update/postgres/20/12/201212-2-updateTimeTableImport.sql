alter table GURU_TIME_TABLE_IMPORT rename column import_file to import_file__u94720 ;
alter table GURU_TIME_TABLE_IMPORT alter column import_file__u94720 drop not null ;
alter table GURU_TIME_TABLE_IMPORT add column IMPORT_XML_DATA text ^
update GURU_TIME_TABLE_IMPORT set IMPORT_XML_DATA = '' where IMPORT_XML_DATA is null ;
alter table GURU_TIME_TABLE_IMPORT alter column IMPORT_XML_DATA set not null ;
