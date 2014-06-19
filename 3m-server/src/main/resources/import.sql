#import.sql file

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_REGULAR_USER');

insert into user (username,password,email,enabled,role,subscribeDate,xp) values ('admin','admin','skytech.application@gmail.com',true,1,'2014/03/10',0);
insert into user (username,password,email,enabled,role,subscribeDate,xp) values ('user','user','tolotolo77@gmail.com',true,2,'2014/04/10',17);
insert into user (username,password,email,enabled,role,subscribeDate,xp) values ('user2','user2','disbled@gmail.com',false,2,'2014/06/16',149);

insert into user_follower (userId, followerId) values (1,2)
insert into user_follower (userId, followerId) values (1,3)