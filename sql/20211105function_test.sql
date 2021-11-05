--2021.11.05

select orderid, custid, bookid, saleprice, fnc_Interest(saleprice) Interest
from orders;