--2021.11.05
--procedure

--orders 테이블의 판매 도서에 대한 이익을 계산하는 프로시저 (interest)
create or replace procedure interest
as
        --변수선언
        myinterest number;
        price number;
        --1.커서 생성(정의)
        cursor interestcursor is select saleprice from orders;
begin
        myinterest := 0.0;
        --2.커서 오픈
        open interestcursor;
        --반복하면서 각 행의 값을 처리
        loop
            --3. 커서 패치
            fetch interestcursor into price;
            
            --반복문의 탈출
            exit when interestcursor%notfound;  --반복문안에 더이상 값이없을때 탈출한다
            
            --price값을 비교
            if price >= 30000 then
                myinterest := myinterest + price*0.1;
            else
                myinterest := myinterest + price*0.05;
            end if;
        end loop;
        
        --4. 커서 종료
        close interestcursor;
        
        --수익금 총액을 출력
        dbms_output.put_line('전체 이익금: '||myinterest);
end
;

