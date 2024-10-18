create table account(
id varchar2(20) primary key,
name varchar2(10) not null,
pw varchar2(20) not null,
pwhint varchar2(20) not null,
tel varchar2(20) not null,
auth varchar2(1) not null check (auth in ('y','n')));

create table book(
isbn varchar2(20) primary key,
name varchar2(20) not null,
writer varchar2(20) not null,
publisher varchar2(20) not null,
category varchar2(20) not null,
content varchar2(200) not null);

select * from account;

delete account;

delete book;
drop table book;
commit;