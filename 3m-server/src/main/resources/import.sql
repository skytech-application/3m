#import.sql file

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_REGULAR_USER');

insert into user (username,password,email,enabled,role) values ('admin','admin','skytech.application@gmail.com',true,1);
insert into user (username,password,email,enabled,role) values ('user','user','tolotolo77@gmail.com',true,2);

