CREATE TABLE tbl_car_co2 (
    IDX number PRIMARY key,
	CAR varchar2(500),
	MODEL varchar2(500),
	VOLUME number(8),
	WEIGHT number(8),
	CO2 number(8)
);
TRUNCATE TABLE TLB_CAR_CO2;

CREATE SEQUENCE seq_carco2 START WITH 10001;
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Toyota','Aygo',1000,790,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mitsubishi','Space Star',1200,1160,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Skoda','Citigo',1000,929,95);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mini','Cooper',1500,1140,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'VW','Up!',1000,929,90);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Skoda','Fabia',1400,1109,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mercedes','A-Class',1500,1365,92);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Ford','Fiesta',1500,1112,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Audi','A1',1600,1150,98);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Hyundai','i20',1100,980,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Suzuki','Swift',1300,990,101);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Ford','Fiesta',1000,1112,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Honda','Civic',1600,1252,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Hyundai','i30',1600,1326,97);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Opel','Astra',1600,1330,97);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Skoda','Rapid',1600,1119,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Ford','Focus',2000,1328,105);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Ford','Mondeo',1600,1584,94);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Opel','Insignia',2000,1428,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mercedes','C-Class',2100,1365,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Skoda','Octavia',1600,1415,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Volvo','S60',2000,1415,99);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mercedes','CLA',1500,1465,102);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Audi','A4',2000,1490,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Audi','A6',2000,1725,114);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Volvo','V70',1600,1523,109);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mercedes','E-Class',2100,1605,115);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Volvo','XC70',2000,1746,117);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Ford','B-Max',1600,1235,104);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Opel','Zafira',1600,1405,109);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mercedes','SLK',2500,1395,102);
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Mitsubishi','Lancer EVO',1800,1360,110);

SELECT * FROM TBL_CARCO2;

drop Table TBL_CAR_CO2;


SELECT CAR, COUNT(*) FROM TBL_CAR_CO2 GROUP BY CAR;
SELECT CAR, AVG(VOLUME), AVG(WEIGHT), AVG(CO2) FROM TBL_CAR_CO2 GROUP BY CAR;
SELECT CAR, ROUND(AVG(VOLUME),0), ROUND(AVG(WEIGHT),0), ROUND(AVG(CO2),0) FROM TBL_CAR_CO2 WHERE WEIGHT > 1200 GROUP BY CAR;
SELECT car, round(avg(CO2)) AS "Co2 AVG" FROM TBL_CAR_CO2 GROUP BY CAR HAVING round(AVG(CO2))<100 ORDER BY "Co2 AVG";


--소수점 두번째 자리 까지만표기 (자동 반올림) TBL_CAR_C02에서 각 브랜드별 가장 무거운 무게의 차량 무게 조회해보기
/*
SELECT car, round(max(WEIGHT),2) AS "WeigthMax" FROM TBL_CAR_CO2 GROUP BY CAR;
*/
--CAR = 'Hyundai',MODEL = 'Elantra',VOLUME = NULL,WEIGHT = 1250,CO2 = 115;로 데이터 추가후 NULL값을 '1598'로 수정후(NULL로 설정된 모든 차량이 함께 적용되도 상관없음) 데이터 조회해보기
/*
INSERT INTO tbl_car_co2(IDX, CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES (seq_carco2.nextval,'Hyundai','Elantra',NULL,1250,115);
UPDATE tbl_car_co2 SET VOLUME = 1598 where model = 'Elantra';
SELECT car , round(max(WEIGHT),2) AS "WeigthMax" FROM TBL_CAR_CO2 GROUP BY CAR;
*/
