--2021.11.05
--procedure


desc book;
--Book 테이블에 저장된 도서의 평균가격을 반환하는 프로시저 (AveragePrice) 
create or replace procedure avgprice(
        --매개변수선언
        averageval out number
)
as
begin
        select avg(price) into averageval from book where price is not null;
end
;
