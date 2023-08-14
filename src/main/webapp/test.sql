create table test (
id int(10) not null auto_increment primary key ,
name varchar(10)
);

insert into test(name) values("가가가");
insert into test(name) values("가나나");
insert into test(name) values("가나다");

select * from test ;

drop table test;

select * from users;