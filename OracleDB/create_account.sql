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

create table loanlist(
isbn varchar2(20) not null,
title varchar2(50) not null,
writer varchar2(20) not null,
category varchar2(10) not null,
id varchar2(20) not null,
bookcnt number(2) not null,
constraint fk_isbn foreign key(isbn) references book(isbn) on delete cascade,
constraint fk_id foreign key(id) references account(id) on delete cascade);

insert into book values ('9788936434120','소년이 온다','한강','소설','5');
insert into book values ('9788936434595','채식주의자','한강','소설','3');
insert into book values ('2090000151824','다시, 역사의쓸모','최태성','역사/문화','4');
insert into book values ('9788959897223','트렌드 코리아 2025','김난도 외 10명','경제/경영','10');
insert into book values ('9788932024639','서랍에 저녁을 넣어 두었다','한강','시/에세이','3');
insert into book values ('9791194330424','넥서스','유발 하라리','인문','2');
insert into book values ('9791198945617','이별이 어려운 너에게 전하는 말','지민석','시/에세이','4');
insert into book values ('9791157847679','박태웅의 AI 강의 2025','박태웅','경제/경영','4');
insert into book values ('9788934985501','디바인 매트릭스, 느낌이 현실이 된다','그렉 브레이든','자기계발','1');
insert into book values ('9791194033127','더 좋은 문장을 쓰고 싶은 당신을 위한 필사책','이주윤','인문','5');
insert into book values ('9791168342286','그거 사전','홍성윤','인문','7');

alter table book modify title varchar2(50);
alter table loanlist modify title varchar2(50);
alter table loanlist add bookcnt number(2) not null; 

select * from account;
select * from loanlist;
select * from book;

drop table loanlist;
insert into loanlist values('9791168342286','그거 사전','홍성윤','인문','test','2');
desc account;
desc book;
desc loanlist;

delete book;
delete loanlist;

delete from book where isbn = '9791168342286';
delete from account where id = 'asd';
update account set auth = 'y' where id = 'admin';

commit;