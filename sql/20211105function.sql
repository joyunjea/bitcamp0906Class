--2021.11.05

CREATE OR REPLACE FUNCTION fnc_Interest(
        price NUMBER) 
        RETURN INT
is
        myinterest number;
begin
        if price>= 30000 then
        myinterest := price*0.1;
        else
        myinterest :=price*0.05;
        end if;
        --값을 반환
        return myinterest;
end;