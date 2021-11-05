--2021.11.05

--INDEX : 검색의 성능을 높이기 위해 사용하는 객체

--물리적인 저장공간을 가진다 -> 저장공간확보필요

drop table emp01;
create table emp01
as
select *from emp;
select count(*) from emp01;
select * from emp01;
insert into emp01 (empno, ename) values (1000, 'test1');

select * from emp01 where ename = 'test';
--많은 데이터 입력
insert into emp01 select * from emp01 where ename='test1';

create index emp01_index on emp01(ename);