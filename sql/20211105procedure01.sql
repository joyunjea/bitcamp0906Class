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
