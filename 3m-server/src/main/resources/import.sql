#import.sql file

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_REGULAR_USER');

insert into user (username,password,enabled,role) values ('skytech.application@gmail.com','mdp',true,1);
insert into user (username,password,enabled,role) values ('User 2','mdp',true,2);
insert into user (username,password,enabled,role) values ('User 3','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 4','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 5','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 6','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 7','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 8','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 9','mdp',false,2);
insert into user (username,password,enabled,role) values ('User 10','mdp',false,2);

