--앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.
--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
create table phoneInfo_basic(
        idx number(6) not null constraint phonebasic_idx_pk primary key,
        fr_name VARCHAR2(20) not null,
        fr_phonenumber VARCHAR2(20) not null,
        fr_email VARCHAR2(20),
        fr_address VARCHAR2(20),
        fr_regdate DATE default sysdate       
       --constraint phonebasic_idx_pk primary key(idx)
);
desc phoneinfo_basic;
--insert
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (1,'가나다','01012341234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (2,'라마바','0101234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (3,'사아자','010123412');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (4,'차카타','01012341234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber,fr_email) values (5,'파하','01012341234','12@naver.com');
--select
select * from phoneinfo_basic;

--이름으로검색
select * from phoneinfo_basic
where fr_name like '%나%';
--전화번호검색
select * from phoneinfo_basic
where fr_phonenumber like '%341%';
--시스템 내부에서 관리자가 검색
--예) 리스트-> 상세보기
select * from phoneinfo_basic where idx=1;

--update
--시스템 배부에서 변경 페이지를 이용한 데이터 수정
update phoneinfo_basic
set fr_name='가나다가나다',fr_phonenumber='01098765432', fr_email='1212@gmail.com'
where idx=5;
--delete
delete  from phoneinfo_basic where idx=3;

--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL 
create table phoneInfo_univ(
        idx number(6) not null constraint phoneuniv_idx_pk primary key,
        fr_u_major VARCHAR2(20) default 'N' not null,
        fr_u_year NUMBER(1) default 1 not null,
        fr_ref NUMBER(7) not null references phoneInfo_basic(idx),
        constraint phoneuniv_year_ck check(fr_u_year between 1 and 4)
);

--친구 정보를 입력: 기본 정보 + 학교 정보
--1. 기본 정보 입력
insert into phoneinfo_basic values(6,'손흥민','010-2222-3333','son@gmail.com','LONDON',sysdate);
--2. 학교 정보 입력
insert into phoneInfo_univ values (2,'축구',1,6);
--select
select * from phoneInfo_univ; --이 테이블의 데이터만으로는 의미가 없다

select *
from phoneinfo_basic pb, phoneInfo_univ pucc
where pb.idx = pu.fr_ref;


select pb.fr_name,pb.fr_phonenumber,pu.fr_u_major,pu.fr_u_year
from phoneinfo_basic pb, phoneInfo_univ pu
where pb.idx = pu.fr_ref; 
--pu.fr_ref(+)로 해주면 나머지 출력되지않은 정보도 출력
select pb.fr_name,pb.fr_phonenumber,nvl(pu.fr_u_major,'입력정보없음') major,nvl(pu.fr_u_year,0) year,to_char(pb.fr_regdate, 'YYYY.MM.DD HH24:mm') regdate
from phoneinfo_basic pb, phoneInfo_univ pu
where pb.idx = pu.fr_ref(+); 
--update


--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL