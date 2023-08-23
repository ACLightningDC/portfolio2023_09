
//유저 테스트
select * from users;

//유저 기본 데이터 입력
insert into users(userid, password, name, phone , date) value('1234id' , '1234pw' , '홍진호' , '123-1234-1234' ,now());

//LoginCheck 
select id from users where userid = '1234id' and password = '1234pw';