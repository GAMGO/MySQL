-- 고객 테이블
CREATE TABLE tbl_customer# (
	customer_id varchar2(20) PRIMARY KEY ,    
	name varchar2(20) NOT NULL,		   
	email varchar2(30),
	age number(3) default 0 ,		
	reg_date date 
);

-- 상품 테이블 
CREATE TABLE tbl_product(
	pcode varchar2(20) PRIMARY KEY ,
	category char(2) ,
	pname varchar2(50) NOT NULL,
	price number NOT NULL 
);

-- 구매테이블
CREATE TABLE tbl_buy(
	buy_seq number PRIMARY KEY ,		
	customer_id varchar2(20) NOT NULL ,			
	pcode varchar2(20) NOT NULL ,
	quantity number NOT NULL ,		
	buy_date timestamp
);


-- 외래키 추가
ALTER TABLE tbl_buy ADD 
CONSTRAINT fk_buy_customer
FOREIGN KEY (customer_id)				
			REFERENCES tbl_customer#(customer_id);	
		
ALTER TABLE tbl_buy ADD 	
CONSTRAINT fk_buy_pcode
	FOREIGN KEY (pcode)
			REFERENCES tbl_product(pcode);


-- 시퀀스 생성
CREATE SEQUENCE seq_tblbuy# START WITH 2001;

COMMIT;


select * from TBL_BUY where to_char(buy_date,'yyyy') like '%2025%';
select pname,price from TBL_PRODUCT where category = 'B1' ;
select name,email from TBL_CUSTOMER# where email like '%gmail%';

select tb.CUSTOMER_ID, tc.NAME, tc.EMAIL,tb.BUY_DATE from TBL_PRODUCT tp, TBL_BUY tb
join TBL_CUSTOMER# tc on tc.CUSTOMER_ID = tb.CUSTOMER_ID
where tp.PCODE=tb.PCODE and category = 'B1'; 

select tb.CUSTOMER_ID, tp.PNAME, tp.PRICE, SUM(tp.PRICE*tb.quantity)as "구매가격",to_char(tb.BUY_DATE,'yyyy-mm-dd') as "구매날짜"
from TBL_PRODUCT tp, TBL_BUY tb
join TBL_CUSTOMER# tc on tc.CUSTOMER_ID = tb.CUSTOMER_ID
where tp.PCODE=tb.PCODE and tc.CUSTOMER_ID = 'mina012'
group by tb.CUSTOMER_ID, tp.PNAME, tp.PRICE,tb.BUY_DATE;  

select tp.PCODE as "상품 코드", count(tb.QUANTITY) as "구매 건수" from TBL_PRODUCT tp, TBL_BUY tb
where tp.PCODE=tb.PCODE
group by tp.PCODE; 

select CATEGORY as "카테고리", avg(PRICE) as "평균가격" from TBL_PRODUCT group by CATEGORY order by CATEGORY; 

select to_char(tb.BUY_DATE,'yyyy') as "년도별", SUM(tp.PRICE*tb.quantity)as "구매 금액 합계"
from TBL_PRODUCT tp, TBL_BUY tb
where tp.PCODE=tb.PCODE
group by tb.BUY_DATE
order by tb.BUY_DATE; 

select * from tbl_product;
select * from TBL_BUY tb;
select * from TBL_CUSTOMER# tc;