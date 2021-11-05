--2021.11.05
--procedure
--데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행

--create or replace {프로시저 이름}{매개변수}
--as --선언부
--begin --프로그램 코드 시작
--.....
--end 
--;
desc book;
create or replace procedure insertbook(
        --매개변수선언
        mybookid in number,
        mybookname in varchar2,
        mypublisher in varchar2,
        myprice in number
)
as
begin
        --핵심처리코드
        --매개변수로 받은 데이터를 이용해서 데이터를 삽입
        insert into book (bookid, bookname, publisher, price)
        values (mybookid, mybookname, mypublisher, myprice);
end     --코드실행종료
;

--프로시저 호출: 실행 요청
--exec 프로시저이름 (매개변수 값,......);
exec insertbook(13, '스포츠과학','마당과학서적',25000);
select * from book;
--같은 이름의 책을 등록해보고, 다른 이름의 책을 입력
--같은 이름의 책 등록
exec bookinsertorupdate(13,'스포츠과학','마당과학서적',10000);
exec bookinsertorupdate(16,'스포츠즐거움','마당과학서적',40000);

delete from book where bookid =15;      --15번 책 삭제
----------------------------------------------------------------

set serveroutput on;
declare 
        avgval number;
begin
        --프로시저 호출
        avgprice(avgval);
        dbms_output.put_line('책값 평균 : '|| avgval);
end;

-------------------------
set serveroutput on;
exec interest;