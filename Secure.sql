create table RegisterForm(id number(3) NOT NULL,username varchar2(30),password varchar2(30),email varchar2(30),gender varchar2(30),phone varchar2(30));

create table upload(id number(3) NOT NULL,name varchar2(30),filename varchar2(30));
create table download(id number(3) NOT NULL,name varchar2(30),filename varchar2(30));
drop table Register;
drop table upload;
drop table upload;
drop table download;

create table Register(rid number(3) NOT NULL,username varchar2(30),password varchar2(30),email varchar2(30),gender varchar2(30),phone varchar2(30));
create table SendFile(sid number(3) NOT NULL,rid number(3) NOT NULL);
drop table SendFile;
create table DownloadFile(did number(3) NOT NULL,rid number(3) NOT NULL,fid number(3) NOT NULL,keyactive varchar2(30));
create table FileType(fid number(3) NOT NULL,rid number(3) NOT NULL,name varchar2(300),ciphertext varchar2(300),keytext varchar2(300),email varchar2(500));
create table SendFile(sid number(3) NOT NULL,rid number(3) NOT NULL,sendactive varchar2(30));

drop table FileType;
drop table DownloadFile;

select * from FileType 
alter table FileType add remail varchar2(500);

alter table FileType add uploaddate varchar2(500);


alter table DownloadFile add email varchar2(500);

select * from Register where rid!=1;

select * from FileType where rid=2 and fid in(select fid from DOWNLOADFILE where keyactive='true');

insert into FileType values((select max(fid) from FileType)+1,1,'ComboBoxTest.txt','ComboBoxTest.encrypted','mary has one dog','kyawtkyawtshwesin2019@gmail.com','')

select f.*,d.email from FileType f, DownloadFile d where f.rid=2 and f.fid in(select d.fid from DOWNLOADFILE d where d.keyactive='true')


