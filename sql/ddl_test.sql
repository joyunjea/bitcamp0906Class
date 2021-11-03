--ddl test
drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;
create table phoneInfo_basic(
        idx number(6) not null constraint phonebasic_idx_pk primary key,
        fr_name VARCHAR2(20) not null,
        fr_phonenumber VARCHAR2(20) not null,
        fr_email VARCHAR2(20),
        fr_address VARCHAR2(20),
        fr_regdate DATE default sysdate       
       --constraint phonebasic_idx_pk primary key(idx)
);
select * from phoneInfo_basic;


create table phoneInfo_univ(
        idx number(6) not null constraint phoneuniv_idx_pk primary key,
        fr_u_major VARCHAR2(20) default 'N' not null,
        fr_u_year NUMBER(1) default 1 not null,
        fr_ref NUMBER(7) not null references phoneInfo_basic(idx),
        constraint phoneuniv_year_ck check(fr_u_year between 1 and 4)
);
select * from phoneInfo_univ;


create table phoneInfo_com(
        idx NUMBER(6) not null constraint phonecom_idx_pk primary key,
        fr_c_company VARCHAR2(20) default 'N' not null,
        fr_ref NUMBER(6) not null references phoneinfo_basic(idx)
);
select * from phoneinfo_com;

DESC phoneInfo_basic;
DESC phoneInfo_univ;
DESC phoneInfo_com;

--테스트1
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (1,'가나다','01012341234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (2,'가','0101234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (3,'나','010123412');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber) values (4,'다','01012341234');
insert into phoneInfo_basic (idx,fr_name,fr_phonenumber,fr_email) values (5,'라','01012341234','12@naver.com');


--테스트2
insert into phoneInfo_univ (idx,fr_u_major,fr_u_year,fr_ref) values (1,'수학과',1,3);
insert into phoneinfo_univ values (2, '유아교육과',1,2);
insert into phoneinfo_univ values (4, '기계공학과',2,4);
insert into phoneInfo_univ (idx,fr_ref) values (5,2);

--테스트3
insert into phoneInfo_com univ values (1,'삼성',1);
insert into phoneInfo_com univ values (2,'네이버',3);
insert into phoneInfo_com (idx,fr_ref) values (3,3);

