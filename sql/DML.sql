create table tbl_student(
    stuno char(7) primary key,
    name varchar2(30) not null,
    age number check (age between 10 and 30),
    addr VARCHAR2 (100)
);
CREATE SEQUENCE seq_student START WITH 2025001;
insert into tbl_student(stuno,name) VALUES(seq_student.nextval,'김모모');
insert into tbl_student(stuno,name) VALUES(seq_student.nextval,'최사나');
insert into tbl_student(stuno,name) VALUES(seq_student.nextval,'김모모');
commit;
update TBL_STUDENT set age = 21 where stuno = '2025001';
update TBL_STUDENT set age = 23 where stuno = '2025002';
update TBL_STUDENT set name = '이하니',age = 20 where stuno = '2025003';
ROLLBACK;
delete from TBL_STUDENT where STUNO='2025002';
select * from TBL_STUDENT;                                                          
select name,stuno from tbl_student;