create table contact(
    idx number(6) constraint contact_idx_pk primary key,
    contact_name varchar(20) not null,
    contact_phonenumber varchar(20) not null,
    contact_address varchar(20),
    contact_email varchar(20)
);
select * from contact;
insert into contact
        values (1 , '손흥민', '010-0000-0000', 'LONDON','son@gmail.com');
insert into contact
        values (2 , '이강인', '010-9999-9999', 'LONDON','lee@gmail.com');

select * from dept;
--2번
insert into dept
(deptno, dname, loc) 
values (50, 'business' ,'huston');
--3번
update dept
set dname='management', loc='Washington' 
where deptno=50;
--4번

delete from dept
where deptno=50;

--5번
select * from tab;

--6번
desc dept;

--7번
constraint

--8번
create index emp_index
on emp(ename);
--9번
select * from emp;
select * from dept;
select * from emp_view;

create or replace view emp_view
as select ename, empno, deptno from emp;

--10번
--EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경
select deptno
from emp
where ename= 'SCOTT';

update emp
set deptno = 20;
where ename = 'SCOTT'

select * from emp;
update emp
set deptno = (select deptno from emp where ename ='SCOTT');

create table emptest 
as select * 
from emp; 
--1번
CREATE TABLE Book (
	bookid NUMBER(2) PRIMARY KEY,
	bookname VARCHAR2(40),
	publisher VARCHAR2(40),
	price NUMBER(8) 
);
CREATE TABLE Book_log(
	bookid_l NUMBER,
	bookname_l VARCHAR2(40),
	publisher_l VARCHAR2(40),
	price_l NUMBER
);
select * from book;
select * from Book_log;
----
create or replace procedure BookInsertOrUpdate(
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number
)
as
    mycount number;
begin
    select count(*) into mycount from book where bookname like myBookName;
    if mycount != 0 then
        update book set price = myPrice where bookname like myBookName;
    else 
        insert into book values (myBookId, myBookName, myPublisher, myPrice);
    end if;
end
;

exec book

select * from book;

exec BookInsertOrUpdate(13, '스포츠과학10', '마당과학서적', 25000);

﻿
select deptno, count(*), round(avg(sal),2)

from emp

group by deptno

;

﻿create user 'java85'@'localhost' identified by 1111;
