create database mapleview;
use mapleview;

Create Table User
(
	userId int NOT NULL,
    name varchar(100),
    email varchar(100),
    password varchar(100),
    userType int,
	CONSTRAINT PK_USER PRIMARY KEY (userId)
);

insert into User values(1, "Usman", "1@1.com", "1", 1);

select * from user;