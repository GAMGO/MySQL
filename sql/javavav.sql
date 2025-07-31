-- 1. 수치값 함수(정수 또는 실수 number를 대상으로 하는 함수)

-- (1) 결과값 소수점 있는 실수	
-- trunc(수치값,자리수) : 소수점 이하 자리수 맞추기 위해서 버림   3.177567  -> 3.17
SELECT trunc(3.177567,2) FROM dual;

-- round(수치값,자리수) :                  반올림  3.177567 -> 3.18
SELECT round(3.177567,2) FROM dual; 
SELECT round(3.177567,0) FROM dual;    -- 소수점 자리수 0 -> 정수 
SELECT round(3.577567,0) FROM dual;

-- (2) 결과값 정수
-- ceil(수치값) : 실수를 `정수`로 올림으로 변환.   ceil:천장
SELECT ceil(3.177567) FROM dual;		-- 결과값 : 4

-- floor(수치값) : 실수를 `정수`로 내림으로 변환.  floor : 바닥
SELECT floor(3.177567) FROM dual;		-- 결과값 : 3


-- 2. 문자열 함수
SELECT INITCAP('hello java') FROM dual;	-- initail capital  : 단어 시작 대문자 
			
SELECT UPPER('hello') FROM dual; 	-- 대문자로 변환 . HELLO
SELECT LOWER('OraCle') FROM dual; 	-- 소문자로 변환.  oracle
SELECT LENGTH('oracle') FROM dual;   -- 문자열 길이. 6
SELECT SUBSTR('java program',3,5)   	-- 부분 추출(문자열,위치,길이) 결과 : 
			FROM dual;-- *오라클에서 문자열 위치 인덱스는 1부터 시작.*	
SELECT SUBSTR('java program',-5,3)		-- 부분 추출 결과 : 위치음수이면 뒤에서부터 . 문자열 뒤에서부터 5번째 3개
			FROM dual;
SELECT REPLACE('java program','pro','프로')		--문자열 바꾸기. java 프로gram
			FROM dual;
SELECT INSTR('java program','og')		-- 자바의 indexOf 
			FROM dual;	--결과 8. 해당 문자열이 없으면 결과 0 
SELECT TRIM(' java program   ')				-- 공백(불필요한 앞뒤 공백)제거
			FROM dual;
SELECT LENGTH(' java program   ') FROM dual;		-- 공백포함 16
SELECT LENGTH(TRIM(' java program   ')) FROM dual;  -- 공백제거 후에는 12