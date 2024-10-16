create table account(
id varchar2(20) primary key,
name varchar2(10) not null,
pw varchar2(20) not null,
pwhint varchar2(20) not null,
tel varchar2(20) not null,
auth varchar2(1) not null check (auth in ('y','n')));

select * from account;

delete account;