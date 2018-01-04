create table sys_dict(
id varchar2(100 byte)	not null primary key,
value	varchar2(1000 byte),
LABEL	VARCHAR2(1000 BYTE),
type	varchar2(100 byte),
description	varchar2(1000 BYTE),
SORT	NUMBER(10,0),
parent_id	varchar2(64 byte),
create_by	varchar2(64 byte),
create_date	date,
update_by	varchar2(64 byte),
update_date	date,
remarks	varchar2(1000 byte),
del_flag	char(1 byte)
);
comment on column sys_dict.id is '字典主键'; 
comment on column sys_dict.value is '值'; 
comment on column sys_dict.label is '标签'; 
comment on column sys_dict.type is '字典类型'; 
comment on column sys_dict.description is '描述'; 
comment on column sys_dict.SORT is '排序'; 
comment on column sys_dict.parent_id is '父ID'; 
comment on column sys_dict.CREATE_BY is '创建人'; 
comment on column sys_dict.create_date is '创建时间'; 
comment on column sys_dict.remarks is '备注'; 
comment on column sys_dict.DEL_FLAG is '是否删除'; 