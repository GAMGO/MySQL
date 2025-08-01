SELECT car,model,co2, avg(co2) OVER(ORDER BY car) FROM TBL_CAR_CO2;
SELECT car,model,co2,rank() over(order by co2) from tbl_car_co2;
SELECT car,model,co2,rank() over(partition by car order by co2) from tbl_car_co2;
SELECT car,model,co2,row_number() over(order by co2) from tbl_car_co2 where car = 'Hyundai';
select * from (SELECT car,model,co2,rank() over(partition by car order by co2) as "co2" from tbl_car_co2)where "co2"=1;
select * from (SELECT car,model,co2,rank() over(partition by car order by co2 desc) as "co2" from tbl_car_co2)where "co2"=1;
select * from TBL_CAR_CO2 ORDER BY car, co2 DESC,weight;





TRUNCATE TABLE tbl_student;
INSERT INTO tbl_student  VALUES ('2024004','김부각',22,'서울시 노원구');
INSERT INTO tbl_student  VALUES ('2024005','이사나',22,'경기도 이천시');
INSERT INTO tbl_student  VALUES ('2024006','박다현',22,'전라북도 전주시');
INSERT INTO tbl_student  VALUES ('2024007','고봉밥',22,'경상남도 부산시');
SELECT * FROM TBL_STUDENT;

CREATE TABLE TBL_SCORE(
    idx number PRIMARY key,
    stuno char(7) not null,
    jumsu number not null,
    teacher varchar2(100) not NULL,
    subject varchar2(20) not NULL,
    term char(8) not null,
    foreign key(stuno) references TBL_STUDENT(stuno)
); 
INSERT INTO TBL_SCORE VALUES (8,'2024004',92,'김길동','국어','2025_2');
INSERT INTO TBL_SCORE VALUES (2,'2024005',96,'김길동','국어','2025_2');
INSERT INTO TBL_SCORE VALUES (3,'2024006',100,'김길동','국어','2025_2');
INSERT INTO TBL_SCORE VALUES (4,'2024007',87,'최수학','수학','2025_2');
INSERT INTO TBL_SCORE VALUES (5,'2024006',49,'최수학','수학','2025_2');
INSERT INTO TBL_SCORE VALUES (6,'2024005',92,'최수학','수학','2025_2');
INSERT INTO TBL_SCORE VALUES (7,'2024004',55,'최수학','수학','2025_2');

select 
* from tbl_score
where stuno ='2024004';

create index idx_score_stuno on tbl_score (stuno);

create SEQUENCE seq_score_idx start with 10;
select seq_score_idx.nextval from dual;

commit;

SELECT * FROM TBL_STUDENT,TBL_SCORE;
SELECT * FROM TBL_STUDENT stu, TBL_SCORE sco WHERE stu.stuno = sco.stuno;
SELECT stu.stuno,stu.name,sco.jumsu from tbl_student stu, tbl_score sco where stu.stuno=sco.stuno;
SELECT stu.name,sco.subject FROM TBL_STUDENT stu,TBL_SCORE sco WHERE sco.jumsu>=90 AND stu.stuno = sco.stuno order by stu.name;
SELECT NAME, STUNO FROM TBL_STUDENT WHERE stuno in (SELECT stuno from tbl_score where jumsu >=90);
SELECT ts.STUNO ,NAME,"avg" FROM TBL_STUDENT ts ,(SELECT stuno, avg(JUMSU) AS "avg" FROM TBL_SCORE ts GROUP BY STUNO HAVING avg(JUMSU) >=90) tg WHERE  ts.STUNO = tg.STUNO;