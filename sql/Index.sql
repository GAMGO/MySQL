/*
오라클의 객체 : 테이블, 인덱스, 시퀀스, 뷰, ...etc
📌 인덱스(Index)란?
검색 속도 향상을 위한 자료구조
테이블의 특정 컬럼 값을 정렬하고, 해당 값의 물리적 위치(포인터)를 저장
마치 책의 목차처럼, 원하는 데이터를 빠르게 찾을 수 있게 해줌
일반적으로 B-Tree(이진트리)나 Hash Table 구조로 구현됨
인덱스가 없으면 전체 테이블 스캔이 발생해 성능 저하 가능

🔐 기본키(Primary Key)란?
테이블에서 각 행을 고유하게 식별하는 컬럼(또는 컬럼 조합)
자동으로 NOT NULL + UNIQUE 제약 조건이 적용됨
테이블당 하나만 설정 가능
기본키를 설정하면 DBMS가 자동으로 고유 인덱스(UNIQUE INDEX)를 생성함

*/
SELECT * FROM tbl_javadict WHERE idx = 4;

--기본키 없는 테이블에 기본키 설정
SELECT * FROM tbl_carco2;

ALTER TABLE TBL_CARCO2 ADD CONSTRAINT pk_carco2 PRIMARY KEY (car,model);
SELECT * FROM TBL_CARCO2 ORDER BY car, model;
ALTER TABLE TBL_CARCO2 DROP PRIMARY KEY; 



SELECT * FROM TBL_CARCO2 WHERE car='Hyundai' AND model = 'i30';

SELECT * FROM tbl_javaword where english = 'order';
CREATE INDEX idx_javaword_eng ON tbl_javaword (english);
SELECT * FROM USER_INDEXES WHERE TABLE_NAME = 'TBL_JAVAWORD';

SELECT test_seq.nextval FROM dual;


CREATE TABLE tbl_car_co2 (
    IDX number PRIMARY key,
	CAR varchar2(500),
	MODEL varchar2(500),
	VOLUME number(8),
	WEIGHT number(8),
	CO2 number(8)
);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Toyota','Aygo',1000,790,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mitsubishi','Space Star',1200,1160,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Skoda','Citigo',1000,929,95);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mini','Cooper',1500,1140,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'VW','Up!',1000,929,90);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Skoda','Fabia',1400,1109,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mercedes','A-Class',1500,1365,92);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Ford','Fiesta',1500,1112,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Audi','A1',1600,1150,98);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Hyundai','i20',1100,980,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Suzuki','Swift',1300,990,101);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Ford','Fiesta',1000,1112,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Honda','Civic',1600,1252,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Hyundai','i30',1600,1326,97);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Opel','Astra',1600,1330,97);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Skoda','Rapid',1600,1119,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Ford','Focus',2000,1328,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Ford','Mondeo',1600,1584,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Opel','Insignia',2000,1428,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mercedes','C-Class',2100,1365,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Skoda','Octavia',1600,1415,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Volvo','S60',2000,1415,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mercedes','CLA',1500,1465,102);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Audi','A4',2000,1490,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Audi','A6',2000,1725,114);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Volvo','V70',1600,1523,109);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mercedes','E-Class',2100,1605,115);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Volvo','XC70',2000,1746,117);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Ford','B-Max',1600,1235,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Opel','Zafira',1600,1405,109);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mercedes','SLK',2500,1395,102);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (TEST_SEQ.nextval,'Mitsubishi','Lancer EVO',1800,1360,110);
SELECT * FROM TBL_CARCO2;
drop Table TBL_CAR_CO2;


drop SEQUENCE test_seq;
create SEQUENCE test_seq;

show AUTOCOMMIT;




