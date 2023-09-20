
//유저 테스트
select * from users;
select * from address;
select * from seller;
select * from sellermall;
select * from product;
select * from order_list;
select * from inquiry;
select * from user_security where check = 0;
select * from delivery;

update user_security set where id = 5 ;
select * from delivery where delivery_company is null;

update order_list set order_count= 3 where users_id = 2 product_id = 2;
update order_list set result= 'P' where id = 1;

select email from users where email = '0523mytop@gmail.com';
select email from users where email = ?;
select email from users where email = ?;
delete from order_list where users_id = 2;
delete from users where id = 3;
select order_count from order_list where users_id= 1 and product_id = 1;

update order_list set order_count= ? where users_id = ? product_id = ? ;

select * from sellermall where users_id = ?

select * from order; where users_id = 1 and product_id = 1 ;

select * from address where users_id = ?;
//유저 기본 데이터 입력
insert into users(userid, password, name, phone , date ,gender , email) value('1234id' , '1234pw' , '홍진호' , '123-1234-1234' ,now() , '남', '0523mytop@gmail.com');
insert into seller(users_id , CompanyRegistrationNumber) value(?,?);
delete from users where userid = 1;

delete from users where id = 2;
delete from order_list where id = ; 
//LoginCheck 
select id from users where userid = '1234id' and password = '1234pw';

select userid from users where name='홍진호' and email = '0523mytop@gmail.com';

update users set password = '' where userid= and email= ; 

insert into users(userid, password, name, phone , birthday ,gender , email) value('1234id' , '1234pw' , '홍진호' , '123-1234-1234' ,now() , '남', '0523mytop@gmail.com');

update users set userid = ?, name = ?, phone = ? , birthday = ? where id = ? 

insert into sellermall(seller_id , name )value(? , ?)

select * from sellermall where seller_id=1;

insert into product(sellerrMall_id , name , kind , img)value(?,?,?,?);

select *  from order_list l join product r on l.product_id = r.id where product_id = 1 ;

select l.id ,product_id ,users_id, order_count , delivery , l.date , result ,sellerMall_id , price , name , kind ,img  from order_list l join product r on l.product_id = r.id where users_id = 2 and result = 'P';
select * from order_list.l join product.r on l.product_id = r.id where users_id = 1 ;

select * from address where users_id='2'; 
update order_list set order_count = ? where id =?

insert into inquiry(users_id , sellerrMall_id , contents , name)value(?,?,?,?);

select * from order_list l join  product c on l.product_id = c.id join sellermall r on l.sellerrMall_id = r.id ; 

배송용 조회 

select * from order_list one join  product two on one.product_id = two.id join delivery three on one.delivery_id = three.id   join address four on three.address_id = four.id ; 

select one.id ,product_id , one.users_id, order_count , delivery_id , one.date , result ,sellerMall_id , price , name , kind ,img ,  three.id
from order_list one join  product two on one.product_id = two.id join delivery three on one.delivery_id = three.id   join address four on three.address_id = four.id ; 

select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result,sellerMall_id , price , name , kind ,img ,c.id
from order_list l join product r on l.product_id = r.id join delivery c  on l.delivery_id = c.id where sellerMall_id = 1  and result = 'P' or result = 'D' order by result desc;

delete from order_list where users_id = 2;


update address set postcode = ? address1 = ? address2 = ? where id = ?;


update order_list set result = ? where id = ?;
insert into delivery (order_list_id,delivery_company,delivery_num)value(?,?,?)
select order_count, result from order_list where users_id= 2 and product_id = 1;

select id , order_count, result from order_list where users_id= 2 and product_id = 1;

insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');
insert into product(sellerMall_id , price ,name ,kind, img)value(1 , 2000 ,'홍길동 쇼핑몰 제품' , '개' ,'Golden_retriever.jpg');

select count(*) cnt from product;
select count(*) cnt from product
select  * from product LIMIT 0 , 15;
select  * from product LIMIT 14 , 15;

select r.address_id from order_list l join users r on l.users_id = r.id ;where id = ? 

select l.id ,product_id ,users_id, order_count , delivery , l.date , result ,sellerMall_id , price , name , kind ,img  from order_list l join product r on l.product_id = r.id where users_id = 2 and result = 'P';
select * from order_list.l join product.r on l.product_id = r.id join where users_id = 1 ;