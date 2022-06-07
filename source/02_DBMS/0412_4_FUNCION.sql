-- [Ⅳ] 단일행 함수 : 내장함수, SQL 주요함수
-- 함수 = 단일행 함수 + 그룹함수(집계함수)
-- 단일행 함수 (INPUT 1행 -> OUTPUT 1행)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM"월"DD"일"') FROM EMP; -- 단일행 함수
SELECT ENAME, INITCAP(ENAME) FROM EMP;

-- 그룹 함수 (INPUT N행 -> OUTPUT 1행)
SELECT SUM(SAL) FROM EMP; -- 전체 SAL 합
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- 부서별 SAL 합

-- 단일행 함수 종류 : 숫자 관련 함수, 문자 관련 함수, 날짜 관련 함수(예약어), 형변환 함수, NVL(), ETC ...
-- 1. 숫자 관련 함수
-- DUAL 테이블 : 오라클에서 제공하는 1행 1열짜리 dummy table
DESC DUAL;
SELECT * FROM DUAL;
SELECT -9, ABS(-9) FROM DUAL; -- 절대값
SELECT FLOOR(34.5678) FROM DUAL;  -- 소수점에서 내림
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- 소수점 두번째자리에서 내림
SELECT TRUNC(34.5678, 2) FROM DUAL; -- 소수점 두번째자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL;  -- 소수점에서 내림
SELECT TRUNC(34, -1) FROM DUAL;  -- 일의 자리에서 내림

SELECT CEIL(34.5678) FROM DUAL;  -- 소수점에서 올림
SELECT CEIL(34.5678*100)/100 FROM DUAL;  -- 소수점 두번째자리에서 올림

SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL; -- 소수점 두번째자리에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL; -- 일의 자리에서 반올림

SELECT MOD(9, 2) FROM DUAL;  --나머지 연산자 9 % 2

-- ex. EMP테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, TRUNC(SAL, -2) FROM EMP;

-- ex. 사번이 홀수인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(EMPNO, 2) != 0;

-- ex. 홀수달에 입사한 사원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) != 0;

-- 2. 문자 관련 함수
-- (1) 대소문자 관련
SELECT UPPER('abcABC') FROM DUAL;  -- 소문자 -> 대문자
SELECT LOWER('abcABC') FROM DUAL;  -- 대문자 -> 소문자
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL;  -- 첫글자만 대문자

-- ex. JOB이 'manager'인 직원의 모든 필드 출력
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';

-- (2) 문자 연결 ( CONCAT, ||연산자)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT('AB', 'CD') FROM DUAL;  -- 매개변수 갯수 2개 제한
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT('EF', 'GH')) FROM DUAL;

-- ex. "아무개(ENAME)는 XX(JOB)이다" 포맷으로 EMP 테이블 정보 출력
SELECT CONCAT(CONCAT(ENAME, '는 '), CONCAT(JOB, '이다')) FROM EMP;
SELECT ENAME||'은 '||JOB||'이다' FROM EMP;

-- (3) SUBSTR(STR, 시작위치,문자갯수) 첫번째위치 : 1, 시작위치 음수 가능
--     SUBSTRB(STR, 시작바이트위치, 문자바이트수)
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3번째 글자부터 2글자 추출 (AC)
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL; -- 3번째 바이트부터 2바이트 추출(AC)
SELECT SUBSTR('데이터베이스', 4, 3) FROM DUAL; -- 4번째 글자부터 3글자 추출(베이스)
SELECT SUBSTRB('데이터베이스', 4, 3) FROM DUAL; -- 4번째 바이트부터 3바이트 추출(이) 한글 1글자는 3BYTE
SELECT SUBSTR('ABCDXD', -1, 1) FROM DUAL;
SELECT SUBSTR(123, 2, 1) FROM DUAL;

-- ex. 9월에 입사한 사원의 모든 필드(단, data 출력 format 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';

-- ex. 9일에 입사한 사원의 모든 필드(data 포맷 : 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';

-- (4) 글자수(LENGTH) VS 바이트수(LENGTHB)
SELECT LENGTH('ABC') FROM DUAL;   -- 글자수 : 3
SELECT LENGTHB('ABC') FROM DUAL;  -- 바이트수 : 3
SELECT LENGTH('오라클') FROM DUAL;  -- 글자수 : 3
SELECT LENGTHB('오라클') FROM DUAL; -- 바이트수 : 9

-- (5) INSTR(STR, 찾을 글자) : STR에서 찾은 글자의 위치 반환 / 글자를 못찾으면 0 반환
--     INSTR(STR, 찾을 글자, 시작위치) : STR에서 시작위치부터 찾아서 찾은 글자의 위치 반환
SELECT INSTR('ABCABC', 'B') FROM DUAL;
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL;
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL;

-- ex. 9월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE INSTR(HIREDATE, '/09/') = 3;
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 3) = 4;

-- ex. 9일에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 6) = 7;

-- ex. 9일이 아닌 날 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 6) = 0;
SELECT * FROM EMP WHERE NOT INSTR(HIREDATE, '09', 6) = 7;

-- (6) LPAD(STR, 자리수, 채울 문자) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울 문자 출력
--     RPAD(STR, 자리수, 채울 문자) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울 문자 출력
SELECT LPAD('ABCABC', 10, '#') FROM DUAL;
SELECT RPAD('ABCABC', 10, '#') FROM DUAL;

-- ex. 사번, 이름 (7788  S****)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') "NAME" FROM EMP;

-- ex. 사번, 이름, 입사일 ( 7788, ____****H, 80/12/**)
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME", RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') "HIREDATE" FROM EMP;
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME", TO_CHAR(HIREDATE, 'RR/MM/')||'**' "HIREDATE" FROM EMP;

-- ex. 이름의 세번째 자리가 R인 사원의 모든 필드(LIKE 사용, INSTR 사용, SUBSTR사용)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 2) = 3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';

-- (7) 여백제거
--  TRIM(STR) : 양쪽 여백 제거
--  RTRIM(STR) : 오른쪽 여백 제거
--  LTRIM(STR) : 왼쪽 여백 제거
SELECT TRIM('     ORACLE DB      ') FROM DUAL;
SELECT RTRIM('     ORACLE DB      ') "A" FROM DUAL;
SELECT LTRIM('     ORACLE DB      ') FROM DUAL;

-- (8) 
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', ' ') FROM EMP;

-- 3. 날짜 관련 함수 및 예약
-- (1) SYSDATE : 지금
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL;
SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 FROM DUAL; -- 어제 이 시간
SELECT SYSDATE+1 FROM DUAL; -- 내일 이 시간

-- (2) 날짜계산 : 14일 후 
SELECT SYSDATE+14 "반납기한일" FROM DUAL;

-- ex. 이름, 입사일, 근무일수
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "WORKINGDAY" FROM EMP;

-- ex. 이름, 입사일, 근무주수, 근무년수
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) "WORKINGWEEK", FLOOR((SYSDATE-HIREDATE)/365) "WORKINGYEAR" FROM EMP;

-- (3) MONTHS_BETWEEN(날짜, 날짜) : 두 날짜간의 개월 수
-- ex. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "WORKINGDAY" FROM EMP;

-- ex. 이름, 입사한 이후 받은 급여와 상여(급여는 매달 sal을 받고, COMM은 1년에 2회 받음)
SELECT ENAME, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL) "TOTAL SAL", FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12)*2*NVL(COMM, 0) "TOTAL COMM" FROM EMP;

-- (4) ADD_MONTHS(날짜, 개월 수) : 특정시점부터 개월 수 후의 날짜
-- ex. 이름, 입사일, 수습종료일(수습기간은 입사일로부터 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "INTERN" FROM EMP;

-- 5) LAST_DAY(특정날짜) : 특정날짜의 달의 말일
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- ex. 이름, 입사일, 첫 월급(월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "FIRST SAL" FROM EMP;

-- (6) ROUND(날짜, XX) : 날짜 반올림 / TRUNC(날짜, XX) : 날짜 버림
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- 결과 : 1월 1일이 가까운 년도로 반환
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;  -- 결과 : 1일이 가까운 월로 반환
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;  -- 결과 : 일요일이 가까운 날짜로 반환
SELECT ROUND(SYSDATE) FROM DUAL;  -- 결과 : 0시가 가까운 0시로 반환

SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- 결과 : 올해 1월 1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;  -- 결과 : 이번달 1일
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;  -- 결과 : 지난 일요일
SELECT TRUNC(SYSDATE) FROM DUAL;  -- 결과 : 오늘 0시

-- ex. 이름, 입사일, 입사한 달의 5일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 FROM EMP;

-- ex. 이름, 입사일, 월급날(월급날은 매달 16일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 "SAL DAY" FROM EMP;

-- ex. 이름, 입사일, 월급날(월급날은 매달 15일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "SAL DAY" FROM EMP;

-- ex. 이름, 입사일, 월급날(월급날은 매달 5일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "SAL DAY" FROM EMP;

-- ex. 이름, 입사일, 월급날(월급날은 매달 20일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "SAL DAY" FROM EMP;

-- (7) NEXT_DAY(날짜, '수') : 특정날짜로부터 처음 도래하는 수요일

-- 4. 형변환 함수 (문자 <->숫자, 문자 <-> 날짜)

-- (1) TO_CHAR(날짜형 데이터, '출력형식')
-- YYYY(년도 4자리) YY / RR (년도 2자리)  MM (월) DD(일)   DY / DAY(요일)
-- AM / PM(오전/오후 구분)  HH12(12시간)   HH24(24시간)   MI(분)   SS(초)

SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY AM HH12:MI:SS') FROM DUAL;

-- (2) TO_CHAR(숫자형 데이터, '출력형식')
-- 0 : 자릿수  (출력 형식의 자릿수가 많으면 0으로 채움)
-- 9 : 자릿수  (출력 형식의 자릿수가 많아도 숫자만큼 출력)
-- , : 세자리마다 , 가능
-- . : 소수점
-- $ : 통화단위 달러
-- L : 지역통화단위

SELECT TO_CHAR(123456, '9,999,999.99') FROM DUAL;
SELECT TO_CHAR(123456, '0,000,000.00') FROM DUAL;
SELECT TO_CHAR(10000, 'L999,999') FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,000') FROM EMP;

-- (3) TO_DATE(문자데이터, '패턴')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD') FROM DUAL;

-- ex. 81/5/1 ~ 83/5/1 사이에 입사한 직원의 모든 필드(TO_DATE)
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('810501', 'RRMMDD') AND TO_DATE('83/05/01', 'RR/MM/DD');

-- (4) TO_NUMBER(문자, '패턴')
SELECT TO_NUMBER('3,456', '9,999') FROM DUAL;

-- 5. NVL(NULL일수도 있는 데이터, NULL이면 대신할 값)  :  매개변수의 타입이 일치해야 함
-- ex. 이름, 상사의 사번(MGR)을 출력 (상사의 사번이 NULL일 경우, 'CEO'로 대신 출력)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

-- 6. ETC
-- (1) EXTRACT : 년도/월/일 을 숫자로 추출하고자 할때 사용
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM') FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;

-- ex. 2월에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '02';

-- ex. 81년도에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
SELECT * FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81';

-- (2) 계층적 출력(레벨별 출력) : LEVEL, START WITH 조건, CONNECT BY PRIOR 조건
SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME FROM EMP 
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO = MGR;



