create table test (
id int(10) not null auto_increment primary key ,
name varchar(10)
);

insert into test(name) values("가가가");
insert into test(name) values("가나나");
insert into test(name) values("가나다");

select * from test ;

drop table test;


//유저 테스트
select * from users;

//유저 기본 데이터 입력
insert into users(userid, password, name, phone) value('1234id' , '1234pw' , '홍진호' , '123-1234-1234');

//LoginCheck 
select id from users where userid = '1234id' and password = '1234pw';