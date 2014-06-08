#import.sql file

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_REGULAR_USER');

insert into user (username,password,enabled,role) values ('admin','admin',true,1);
insert into user (username,password,enabled,role) values ('user','user',true,2);

