select CUSTOMER_ID from tbl_customer UNION select CUSTOMER_ID from tbl_buy;
select CUSTOMER_ID from tbl_customer intersect select CUSTOMER_ID from tbl_buy;
select CUSTOMER_ID from tbl_customer minus select CUSTOMER_ID from tbl_buy;

SELECT * from tbl_buy tb join TBL_CUSTOMER tc on tb.CUSTOMER_ID = tc.CUSTOMER_ID join TBL_PRODUCT tp on tb.PCODE = tp.PCODE order by tb.BUY_SEQ asc;

select tb.buy_seq, tc.customer_id, tc.name, tp.pcode,tp.pname,tp.price*tb.quantity as "구매 금액" from tbl_buy tb join tbl_customer tc on tb.customer_id = tc.customer_id join tbl_product tp on tb.pcode = tp.pcode;

select tp.pcode, tp.pname, tp.price*sale.salesum as total
from tbl_product tp
join (select pcode,sum(quantity) as salesum from tbl_buy tb group by pcode order by salesum desc) sale
on tp.pcode = sale.pcode
order by total desc;

create or replace view v_final_sale as
select tp.pcode, tp.pname, tp.price*sale.salesum as total
from tbl_product tp
join (select pcode,sum(quantity) as salesum from tbl_buy tb group by pcode order by salesum desc) sale
on tp.pcode = sale.pcode
order by total desc;

select * from V_FINAL_SALE;