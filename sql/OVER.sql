SELECT car,model,co2, avg(co2) OVER(ORDER BY car) FROM TBL_CAR_CO2;
SELECT car,model,co2,rank() over(order by co2) from tbl_car_co2;
SELECT car,model,co2,rank() over(partition by car order by co2) from tbl_car_co2;
SELECT car,model,co2,row_number() over(order by co2) from tbl_car_co2 where car = 'Hyundai';
select * from (SELECT car,model,co2,rank() over(partition by car order by co2) as "co2" from tbl_car_co2)where "co2"=1;
select * from (SELECT car,model,co2,rank() over(partition by car order by co2 desc) as "co2" from tbl_car_co2)where "co2"=1;
select * from TBL_CAR_CO2 ORDER BY car, co2 DESC,weight;
