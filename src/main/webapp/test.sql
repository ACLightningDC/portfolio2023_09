
//유저 테스트
select * from users;

//유저 기본 데이터 입력
insert into users(userid, password, name, phone , date ,gender , email) value('1234id' , '1234pw' , '홍진호' , '123-1234-1234' ,now() , '남', '0523mytop@gmail.com');


delete from users where id = 2;
//LoginCheck 
select id from users where userid = '1234id' and password = '1234pw';

select userid from users where name='홍진호' and email = '0523mytop@gmail.com';

update users set password = '' where userid= and email= ; 