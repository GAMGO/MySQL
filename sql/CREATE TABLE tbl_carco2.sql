TRUNCATE TABLE TBL_CARCO2 ;
CREATE TABLE tbl_carco2 (
	CAR varchar2(500),
	MODEL varchar2(500),
	VOLUME number(8),
	WEIGHT number(8),
	CO2 number(8)
);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Toyota','Aygo',1000,790,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mitsubishi','Space Star',1200,1160,94);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Skoda','Citigo',1000,929,95);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mini','Cooper',1500,1140,105);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('VolksWagan','Up!',1000,929,90);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Skoda','Fabia',1400,1109,105);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mercedes','A-Class',1500,1365,92);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Ford','Fiesta',1500,1112,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Audi','A1',1600,1150,98);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Hyundai','i20',1100,980,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Suzuki','Swift',1300,990,101);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Ford','Fiesta',1000,1112,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Honda','Civic',1600,1252,94);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Hyundai','i30',1600,1326,97);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Opel','Astra',1600,1330,97);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Skoda','Rapid',1600,1119,104);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Ford','Focus',2000,1328,105);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Ford','Mondeo',1600,1584,94);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Opel','Insignia',2000,1428,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mercedes','C-Class',2100,1365,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Skoda','Octavia',1600,1415,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Volvo','S60',2000,1415,99);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mercedes','CLA',1500,1465,102);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Audi','A4',2000,1490,104);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Audi','A6',2000,1725,114);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Volvo','V70',1600,1523,109);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mercedes','E-Class',2100,1605,115);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Volvo','XC70',2000,1746,117);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Ford','B-Max',1600,1235,104);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Opel','Zafira',1600,1405,109);
INSERT INTO tbl_carco2(CAR,MODEL,VOLUME,WEIGHT,CO2) VALUES ('Mercedes','SLK',2500,1395,102);
SELECT * FROM TBL_CARCO2;
COMMIT;

--배기량(Volume) 1500이상인 데이터를 모두 조회
SELECT * FROM TBL_CARCO2 WHERE volume >= 1500;

--배기량(Volume) 1500이상인 차량 모델을 모두 조회
SELECT * FROM TBL_CARCO2 WHERE MODEL LIKE 'A%' AND VOLUME >= 1500;

--Co2배출양 100이하인 모델명 I의 차량을 모두 조회
SELECT * FROM TBL_CARCO2 WHERE MODEL LIKE 'I%' AND CO2 <= 100;

-- 차량 모델들의 글자수를 알아보기
SELECT UPPER(CAR), LENGTH(MODEL) FROM TBL_CARCO2 ;

-- 알파벳 H로 시작하는 차량 모델 모두 조회
SELECT * FROM TBL_CARCO2 WHERE CAR LIKE 'H%';

-- H로 시작하는 차량회사만 빼고 조회
 SELECT * FROM TBL_CARCO2 WHERE CAR NOT LIKE 'H%'; 
 --포드만 조회
SELECT * FROM TBL_CARCO2 WHERE CAR ='Ford';

SELECT DISTINCT car,co2 FROM TBL_CARCO2 WHERE VOLUME >=2000;