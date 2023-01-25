create table Register(name varchar(50),password varchar(10),contact varchar(40),address varchar(30),email varchar(40));

insert into SendFile values((select max(sid) from SendFile)+1,' ','false')