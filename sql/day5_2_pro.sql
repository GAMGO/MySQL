
CREATE TABLE tbl_customer
(
  customer_id VARCHAR2(20) NOT NULL,
  name        VARCHAR2(20) ,
  email       VARCHAR2(30) NOT NULL,
  age         number(3,0)  DEFAULT 0 ,
  reg_date    DATE          DEFAULT sysdate,
  PRIMARY KEY (customer_id)
);

CREATE TABLE tbl_product
(
  pcode     VARCHAR2(20),
  pcategory CHAR(2)      NOT NULL,
  pname     VARCHAR2(50)    ,
  price     number          ,
  PRIMARY KEY (pcode)
);

CREATE TABLE tbl_buy
(
  buy_seq     number       NOT NULL,
  pcode       VARCHAR2(20) NOT NULL,
  customer_id VARCHAR2(20) NOT NULL,
  quantity    NUMBER       NOT NULL,
  buy_date    TIMESTAMP    NOT NULL,
  PRIMARY KEY (buy_seq)
);

drop table tbl_buy;

ALTER TABLE tbl_customer
  ADD CONSTRAINT UQ_email UNIQUE (email);

ALTER TABLE tbl_buy
  ADD CONSTRAINT FK_tbl_customer_TO_tbl_buy
    FOREIGN KEY (customer_id)
    REFERENCES tbl_customer (customer_id);

ALTER TABLE tbl_buy
  ADD CONSTRAINT FK_tbl_product_TO_tbl_buy
    FOREIGN KEY (pcode)
    REFERENCES tbl_product (pcode);
    
commit;

alter session set nls_date_format = 'yyyy-mm-dd';
insert into TBL_CUSTOMER VALUES ('mina012',  '김미나',  'kimm@gmail.com',  20,  '2025-03-10');
insert into TBL_CUSTOMER VALUES('hongGD', '홍길동', 'gil@korea.com', 32, '2023-10-21');
insert into TBL_CUSTOMER VALUES('twice', '박모모', 'momo@daum.net', 29, '2024-12-25');
insert into TBL_CUSTOMER VALUES('wonder', '이나나', 'lee@naver.com',20,'2024-12-31');

insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'mina012' , 'CJBAb12g' , 5,TO_DATE('2024-07-15 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'mina012' , 'APLE5kg' , 2,TO_DATE('2024-11-10 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'mina012' , 'JINRMn5' , 2,TO_DATE('2025-02-09 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'twice' , 'JINRMn5' , 3 ,TO_DATE('2023-12-21 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'twice' , 'MANGOTK4r' , 2 ,TO_DATE('2025-01-10 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'hongGD' , 'DOWON123a' , 1 ,TO_DATE('2024-09-09 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval, 'hongGD' , 'APLE5kg' , 1 ,TO_DATE('2025-01-13 14:33:15', 'YYYY-MM-DD HH24:MI:SS'));
insert into tbl_buy (buy_seq,CUSTOMER_ID,PCODE,QUANTITY,buy_date) values(SEQ_TBLBUY.nextval,'hongGD' , 'DOWON123a' , 1 ,TO_DATE('2025-01-13 09:33:15', 'YYYY-MM-DD HH24:MI:SS'));



commit;

select * from tbl_customer where age >= 30;
select * from tbl_customer where CUSTOMER_ID = 'twice';
select max(price) from TBL_PRODUCT;
select sum(quantity) from tbl_buy where pcode = 'JINRMn5';
select (extract(year from tbl_buy.buy_date)) as year from tbl_buy;
select tc.CUSTOMER_ID, tc.NAME, tb.BUY_DATE from TBL_CUSTOMER tc join TBL_BUY tb on tc.CUSTOMER_ID = tb.CUSTOMER_ID;
select * from TBL_BUY;
select * from TBL_PRODUCT;
select extract(YEAR from tb.buy_date) as YEARS, count(QUANTITY) as "구매건 수"  from tbl_buy tb group by extract(YEAR from tb.buy_date) order by years ASC;
select extract(YEAR from tb.buy_date) as YEARS, tb.pcode as "상품별", count(*) as "상품별 건 수"  from tbl_buy tb
group by extract(YEAR from tb.buy_date), tb.PCODE 
order by years,PCODE ASC;