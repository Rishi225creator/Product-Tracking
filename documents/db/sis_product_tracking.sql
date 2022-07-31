
 
  drop table spc_users;
 create table spc_users(
  id number(10) unique ,
  name varchar2(20) not null,
  dob date ,
  login_id varchar2(20) unique not null,
  login_password varchar2(20) not null,
  user_type varchar2(20)  check (user_type in('super admin','admin','employee')),
  mobile varchar2(15) unique,
  email varchar2(20) unique,
  created timestamp default sysdate
  );
  
  desc sis_sm_users;
 
 drop sequence spc_users_seq;
 create sequence spc_users_seq start with 1001;
  
  --- admin ,super admin,  student 
  insert into spc_users(id,name,dob,login_id,login_password,user_type,mobile,email)
  values(spc_users_seq.nextval,'rakesh pathak','10-jan-1990','user1','123','super admin','1234567890','r@gmail');
  
  --  add user by super addin
  
   insert into spc_users(id,name,dob,login_id,login_password,user_type,mobile,email)
  values(spc_users_seq.nextval,'raju','13-feb-2000','user2','123','admin','1234567891','u@gmail');

  insert into spc_users(id,name,dob,login_id,login_password,user_type,mobile,email)
  values(spc_users_seq.nextval,'guddu','4-mar-2000','user3','123','admin','1234567892','g@gmail');
  
    insert into spc_users(id,name,dob,login_id,login_password,user_type,mobile,email)
  values(spc_users_seq.nextval,'riti','14-mar-2000','user4','123','employee','1234567895','rt@gmail');
   
  commit;
  
  select * from spc_users;
  select id,name,dob,login_id,login_password,user_type,mobile,email from spc_users;

   

   
   
    
  drop table spc_category;
 create table spc_category(
  id number(10) ,
  name varchar2(20)  not null,
  details varchar2(120) ,
  created timestamp default sysdate,
  constraint spc_category_pk1  primary key(id),
  constraint spc_category_uk1  unique (name)
  );
   
   drop sequence spc_category_seq;
   create sequence spc_category_seq start with 5001; 
   
   insert into spc_category(id,name,details)values(spc_category_seq.nextval,'cat1','details...');
   insert into spc_category(id,name,details)values(spc_category_seq.nextval,'cat2','details...');
   insert into spc_category(id,name,details)values(spc_category_seq.nextval,'cat3','details...');
   insert into spc_category(id,name,details)values(spc_category_seq.nextval,'cat4','details...');
   
   commit;
   select * from spc_category;
   select * from spc_category where id=5001;
   select * from spc_category where lower(name) like lower('%a%');
--   delete from spc_category where id=123;
--   update spc_category  set name='x', details='y' where id=102;
   
   
   
   
   
  
  
  
  drop table spc_brand;
 create table spc_brand(
  id number(10) ,
  name varchar2(20)  not null,
  details varchar2(120) ,
  created timestamp default sysdate,
  constraint spc_brand_pk1  primary key(id),
  constraint spc_brand_uk1  unique (name)
  );
   
   drop sequence spc_brand_seq;
   create sequence spc_brand_seq start with 6001;
   
   insert into spc_brand(id,name,details)values(spc_brand_seq.nextval,'brand1','details...');
   insert into spc_brand(id,name,details)values(spc_brand_seq.nextval,'brand2','details...');
   insert into spc_brand(id,name,details)values(spc_brand_seq.nextval,'brand3','details...');
   insert into spc_brand(id,name,details)values(spc_brand_seq.nextval,'brand4','details...');
   
   commit;
   select * from spc_brand;
   
  select * from spc_brand;
  select * from spc_brand where id=6001;
  select * from spc_brand where lower(name) like lower('%a%');
--   delete from spc_brand where id=123;
--   update spc_brand  set name='x',details='y' where id=6001;
   
   
   
   
     
  drop table spc_product;
 create table spc_product(
  id number(10) ,
  name varchar2(20)  not null,
  price number(10,2) not null,
  details varchar2(120) ,
  category_id number(10),
  brand_id number(10),
  created timestamp default sysdate,
  constraint spc_product_pk1  primary key(id),
  constraint spc_product_fk1  foreign key(category_id) references  spc_category(id),
  constraint spc_product_fk2  foreign key(brand_id) references  spc_brand(id)
  );
   
      drop sequence spc_product_seq;
   create sequence spc_product_seq start with 10001;
   
    insert into spc_product(id,name,price,details,brand_id ,category_id)values(spc_product_seq.nextval,'product1',2000,'details...',6001,5001);
	
    insert into spc_product(id,name,price,details,brand_id,category_id)values(spc_product_seq.nextval,'product2',2000,'details...',6001,5001);
    insert into spc_product(id,name,price,details,brand_id,category_id)values(spc_product_seq.nextval,'product3',400,'details...',6003,5002);
    insert into spc_product(id,name,price,details,brand_id,category_id)values(spc_product_seq.nextval,'product4',400,'details...',6002,5003);
    insert into spc_product(id,name,price,details,brand_id,category_id)values(spc_product_seq.nextval,'product5',700,'details...',6002,5004);
	
	commit;
	
	select * from spc_product;
	select * from spc_product where category_id=5001;
	
--update  spc_product set name=?,price=?,details=?,brand_id=?,category_id=? where id=?;
	
select * from spc_product where category_id=5001;

select * from spc_product where category_id=(select id from spc_category where name='cat1' );

select * from spc_product where brand_id=6002;

select * from spc_product where brand_id=(select id from spc_brand where name='brand2' );
select * from spc_product where  lower(name) like lower('%d%')



	
	
	
	
	
	select p.id,p.name,p.price,c.name,b.name,p.details from  spc_product p , spc_brand b,spc_category c where p.brand_id=b.id and p.category_id=c.id;
	
	
	
	select p.id,p.name,p.price,c.name,b.name,p.details from  spc_product p , spc_brand b,spc_category c where p.brand_id=b.id and p.category_id=c.id;
	
	
   	select p.id,p.name,p.price,c.id,c.name,b.id,b.name,p.details from  spc_product p , spc_brand b,spc_category c where p.brand_id=b.id and p.category_id=c.id;

   
 --  drop table spc_users;
 --  drop table spc_product;
  -- drop table spc_category;
  -- drop table spc_brand;
   
   
	select * from  spc_users;
	select * from  spc_product;
	select * from  spc_category;
	select * from spc_brand;
   