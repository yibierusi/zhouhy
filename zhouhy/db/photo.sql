create table photo_album(
id varchar2(100 byte)	not null primary key,
name varchar2(100 byte) not null,
content varchar2(1000 byte),
author_id varchar2(100 byte),
photo_id varchar2(100 byte),
photo_path varchar2(100 byte),
read_count number(10) default 0,
comment_count number(10) default 0,
create_time timestamp default sysdate,
update_time timestamp,
del_flag	char(1 byte) default '0'
);
comment on column photo_album.id is '���ID'; 
comment on column photo_album.name is '�������';
comment on column photo_album.content is '������';
comment on column photo_album.author_id is '���������ID';
comment on column photo_album.photo_id is '��������ƬID';
comment on column photo_album.photo_path is '��������Ƭ��ַ';
comment on column photo_album.read_count is '�Ķ���';
comment on column photo_album.comment_count is '������';
comment on column photo_album.create_time is '����ʱ��';
comment on column photo_album.update_time is '����ʱ��';
comment on column photo_album.del_flag is '�Ƿ�ɾ�� 1��ɾ�� 0δɾ��';

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
comment on column photo.id is '��ƬID'; 
comment on column photo.photo_album_id is '���ID'; 
comment on column photo.name is '��Ƭ����';
comment on column photo.path is '��Ƭ·��';
comment on column photo.size1 is '��Ƭ��С';
comment on column photo.suffix is '��Ƭ��׺';
comment on column photo.content is '��Ƭ����';
comment on column photo.read_count is '�Ķ���';
comment on column photo.comment_count is '������';
comment on column photo.create_time is '����ʱ��';
comment on column photo.update_time is '����ʱ��';
comment on column photo.del_flag is '�Ƿ�ɾ�� 1��ɾ�� 0δɾ��';

commit;


