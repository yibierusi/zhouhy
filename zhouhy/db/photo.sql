create table photo_album(
id varchar2(100 byte)	not null primary key,
name varchar2(100 byte) not null,
content varchar2(1000 byte),
author_id varchar2(100 byte),
photo_id varchar2(100 byte),
read_count number(10) default 0,
comment_count number(10) default 0,
create_time timestamp,
update_time timestamp,
del_flag	char(1 byte) default '0'
);
comment on column photo_album.id is '相册ID'; 
comment on column photo_album.name is '相册名字';
comment on column photo_album.content is '相册介绍';
comment on column photo_album.author_id is '相册所属人ID';
comment on column photo_album.photo_id is '相册封面照片ID';
comment on column photo_album.read_count is '阅读数';
comment on column photo_album.comment_count is '评论数';
comment on column photo_album.create_time is '创建时间';
comment on column photo_album.update_time is '更新时间';
comment on column photo_album.del_flag is '是否删除 1：删除 0未删除';

commit;

create table photo(
id varchar2(100 byte)	not null primary key,
photo_album_id varchar2(100 byte),
name varchar2(100 byte) not null,
path varchar2(1000 byte),
suffix varchar2(30 byte),
size1 varchar2(100) default 0,
content varchar2(1000 byte),
read_count number(10) default 0,
comment_count number(10) default 0,
create_time timestamp,
update_time timestamp,
del_flag	char(1 byte) default '0'
);
comment on column photo.id is '相片ID'; 
comment on column photo.photo_album_id is '相册ID'; 
comment on column photo.name is '相片名字';
comment on column photo.path is '相片路径';
comment on column photo.size1 is '相片大小';
comment on column photo.suffix is '相片后缀';
comment on column photo.content is '相片介绍';
comment on column photo.read_count is '阅读数';
comment on column photo.comment_count is '评论数';
comment on column photo.create_time is '创建时间';
comment on column photo.update_time is '更新时间';
comment on column photo.del_flag is '是否删除 1：删除 0未删除';

commit;


