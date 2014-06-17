#import.sql file

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_REGULAR_USER');

insert into user (username,password,email,enabled,role,subscribeDate) values ('admin','admin','skytech.application@gmail.com',true,1,'2014/10/10');
insert into user (username,password,email,enabled,role,subscribeDate) values ('user','user','tolotolo77@gmail.com',true,2,'2014/10/10');
insert into user (username,password,email,enabled,role,subscribeDate) values ('user2','user2','disbled@gmail.com',false,2,'2014/10/10');

