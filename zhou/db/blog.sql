create table blog(
id varchar2(100 byte)	not null primary key,
title varchar2(500 byte),
content varchar2(1000 byte),
author_id varchar2(100 byte),
read_count number(10) default 0,
comment_count number(10) default 0,
create_time timestamp,
update_time timestamp,
del_flag	char(1 byte) default '0'
);
comment on column blog.id is '博客id'; 
comment on column blog.title is '博客标题';
comment on column blog.content is '博客内容';
comment on column blog.author_id is '作者ID';
comment on column blog.read_count is '阅读数';
comment on column blog.comment_count is '评论数';
comment on column blog.create_time is '发表时间';
comment on column blog.update_time is '更新时间';
comment on column blog.del_flag is '是否删除 1：删除 0未删除';




