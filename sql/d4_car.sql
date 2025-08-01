CREATE TABLE tbl_customer
(
  c_id   NUMBER NOT NULL,
  c_no   VARCHAR2(20) NOT NULL UNIQUE,
  c_typ  VARCHAR2(20) NOT NULL,
  c_tel  VARCHAR2(20) NOT NULL,
  c_addr VARCHAR2(100),
  CONSTRAINT PK_tbl_customer PRIMARY KEY (c_id)
);

CREATE TABLE tbl_office
(
  o_num  CHAR(3) NOT NULL,
  o_addr VARCHAR2(200) NOT NULL,
  o_tel  VARCHAR2(20) NOT NULL,
  CONSTRAINT PK_tbl_office PRIMARY KEY (o_num)
);

CREATE TABLE tbl_truck
(
  t_no      VARCHAR2(30) NOT NULL UNIQUE,
  t_size    VARCHAR2(20) NOT NULL,
  t_mxDate  DATE,
  t_expDate DATE,
  CONSTRAINT PK_tbl_truck PRIMARY KEY (t_no)
);

CREATE TABLE tbl_contract
(
  con_num     NUMBER NOT NULL,
  startOff_no CHAR(3) NOT NULL,
  endOff_no   CHAR(3) NOT NULL,
  t_no        VARCHAR2(30) NOT NULL,
  c_no        NUMBER NOT NULL,
  start_hist  NUMBER NOT NULL,
  end_hist    NUMBER NOT NULL,
  CONSTRAINT PK_tbl_contract PRIMARY KEY (con_num)
);
ALTER TABLE tbl_contract
  ADD CONSTRAINT FK_tbl_office_TO_tbl_contract
    FOREIGN KEY (startOff_no)
    REFERENCES tbl_office (o_num);

ALTER TABLE tbl_contract
  ADD CONSTRAINT FK_tbl_truck_TO_tbl_contract
    FOREIGN KEY (t_no)
    REFERENCES tbl_truck (t_no);

ALTER TABLE tbl_contract
  ADD CONSTRAINT FK_tbl_customer_TO_tbl_contract
    FOREIGN KEY (c_no)
    REFERENCES tbl_customer (c_id);

ALTER TABLE tbl_contract
  ADD CONSTRAINT FK_tbl_office_TO_tbl_contract1
    FOREIGN KEY (endOff_no)
    REFERENCES tbl_office (o_num);

