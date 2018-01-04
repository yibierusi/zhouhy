create table sys_user(
id varchar2(100 byte)	not null primary key,
username varchar2(100 byte)	not null,
password varchar2(100 byte)	not null,
nickname varchar2(100 byte)	,
sex varchar2(100 byte)	,
birth_date date,
ico varchar2(400 byte),
signature varchar2(400 byte),	
email varchar2(100 byte)	,
phone varchar2(100 byte)	,
mobile varchar2(100 byte)	,
user_type varchar2(100 byte)	,
user_state varchar2(100 byte),
login_time date	,
login_ip varchar2(100 byte)	,
registered_time date,
registered_ip varchar2(100 byte)	,
update_by  varchar2(100 byte)	,
update_date date,
remarks	varchar2(255 byte),
del_flag	char(1 byte)
);
comment on column sys_user.id is '用户主键'; 
COMMENT ON column sys_user.username is '用户名字'; 
comment on column sys_user.password is '用户密码'; 
COMMENT ON column sys_user.nickname is '用户昵称'; 
COMMENT ON column sys_user.sex is '性别'; 
COMMENT ON column sys_user.birth_date is '生日'; 
COMMENT ON column sys_user.ico is '头像'; 
COMMENT ON column sys_user.Signature is '签名'; 
COMMENT ON column sys_user.email is '邮箱'; 
COMMENT ON column sys_user.phone is '电话'; 
COMMENT ON column sys_user.mobile is '手机'; 
COMMENT ON column sys_user.user_type is '用户类型'; 
COMMENT ON column sys_user.user_state is '用户状态'; 
COMMENT ON column sys_user.login_time is '登录时间'; 
COMMENT ON column sys_user.login_ip is '登录IP'; 
COMMENT ON column sys_user.registered_time is '注册时间'; 
COMMENT ON column sys_user.registered_ip is '注册IP'; 
COMMENT ON column sys_user.update_by is '更新人'; 
COMMENT ON column sys_user.update_date is '更新时间'; 
COMMENT ON column sys_user.remarks is '备注'; 
COMMENT ON column sys_user.del_flag is '是否删除'; 
