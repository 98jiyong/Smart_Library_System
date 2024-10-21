create table account(
id varchar2(20) primary key,
name varchar2(10) not null,
pw varchar2(20) not null,
pwhint varchar2(20) not null,
tel varchar2(20) not null,
auth varchar2(1) not null check (auth in ('y','n')));

create table book(
isbn varchar2(20) primary key,
title varchar2(20) not null,
writer varchar2(20) not null,
category varchar2(10) not null,
bookcnt NUMBER(2) not null);

insert into book values ('12345','하울의 움직이는 성','무라카미 하루키','소설','2');
insert into book values ('12346','하울의 움직이는 성','무라카미 하루키','소설','2');
insert into book values ('12347','하울의 움직이는 성','무라카미 하루키','소설','2');
insert into book values ('12348','하울의 움직이는 성','무라카미 하루키','소설','2');
insert into book values ('12349','하울의 움직이는 성','무라카미 하루키','소설','2');
insert into book values ('12350','하울의 움직이는 성','무라카미 하루키','소설','2');

select * from account;
select * from book;

delete from account where id = 'lucky';
update account set pwhint = '김철기' where id = 'abc123';

commit;