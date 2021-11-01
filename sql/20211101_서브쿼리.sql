--2021.11.01

--서브 쿼리 (부속 질의)
--select 구문안의 또 다른 select구문을 이용하는 sqlans

--SCOTT 사원의 부서 이름 출력
select dname,emp.deptno
from emp, dept
where emp.deptno=dept.deptno and ename='SCOTT';

select dname 
from dept
where deptno=(select deptno from emp where ename='SCOTT');
--scott사원의 부서 이름
--1.내부 쿼리를 먼저 작성: scott 사원의 부서 번호
--2. 외부 쿼리 작성 : 부서 번호로 부서 이름을 검색

select deptno from emp where ename='SCOTT';
select dname 
from dept
where deptno=(select deptno from emp where ename='SCOTT');

select deptno, dname from dept where deptno > 20;

--서브쿼리
-- 마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력).
select * from customer;
select * from orders;
select custid,
    (select name from customer c where o.custid = c.custid) as name,
    sum(saleprice) 
from orders o
group by custid;

--join
--마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력).
select o.custid, c.name, sum(o.saleprice)
from orders o , customer c
where o.custid=c.custid
group by o.custid, c.name;

--사원의 이름과 부서 이름을 출력
select ename,
    (select dname from dept where emp.deptno=dept.deptno)
from emp;

select ename, dname
from emp, dept
where emp.deptno=dept.deptno;

--인라인뷰 : from 뒤에 오는 서브 쿼리 -> select의 결과를 테이블로 사용
-- 고객번호가 2 이하인 고객의 판매액을 보이시오 (결과는 고객이름과 고객별 판매액 출력)
select custid, name 
from customer 
where custid <= 2;

select o.custid, sum(saleprice)
from orders o,
        (select custid, name from customer where custid <= 2) c
where o.custid=c.custid
group by o.custid;

select custid
from orders
where custid <=2
group by custid;

--30번 부서의 인라인 뷰를 만들어서 사용
select *
from(select * from emp where deptno=30);