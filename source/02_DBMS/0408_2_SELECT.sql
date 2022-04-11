-- [Ⅱ] SELECT 문 - 가장 많이 쓰이는 DML(Data Manipulation Language) : 검색 기능
-- 1. SELECT문장 작성법

-- 현재 계정 (실행 : ctrl + Enter)
SHOW USER;
SELECT * FROM TAB;  -- 현 계정(scott)의 테이블 확인
SELECT * FROM EMP;  -- EMP 테이블의 모든 열(필드), 모든행 확인
SELECT * FROM DEPT; -- DEPT 테이블의 모든 열, 모든 행

-- EMP 테이블의 구조
DESC EMP;
DESC DEPT;

-- 2. SQL문 실행 (특정 열만 출력)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB FROM EMP; -- 별칭
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여, JOB FROM EMP;
SELECT EMPNO  사번, ENAME  이름, SAL  급여, JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP;  -- TITLE : NO, NAME, SALARY

-- 3. 특정 행만 출력 : WHERE 절(조건) / 비교연산자 - 같다(=), 다르다(!= / ^= / <>)
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000;  -- 같다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL != 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL ^= 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL <> 3000; -- 다르다

-- 비교연산자는 숫자, 문자, 날짜형 모두 가능
-- ex. 사원이름(ENAME)이 'A', 'B', 'C',로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME < 'D';

-- ex. 81년도 이전에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';

-- ex. 10번 부서번호(deptno)인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10;

-- ex. 이름(ENAME)이 FORD인 직원의 사번(EMPNO), ENAME, MGR
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
select empno, ename, mgr from emp where ename = 'FORD';  -- 데이터는 대소문자 구분

-- 4. 논리연산자 : AND, OR, NOT
-- ex. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <= 3000;

-- ex. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

-- ex. 날짜 표기법 셋팅 (현재 : YY/MM/DD = RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 한글 Windows 기준 날짜 셋팅
SELECT ENAME, HIREDATE FROM EMP;

-- 날짜형 -> 문자형으로 변환하는 함수 : TO_CHAR(날짜형, 패턴)
SELECT EMPNO "사번", ENAME "이름", JOB "업무", HIREDATE "입사일" FROM EMP -- 단일행함수(4장 참조)
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/01/31';
    
-- 문자형 -> 날짜형으로 변환하는 함수 : TO_DATE(문자형, 패턴)
SELECT EMPNO "사번", ENAME "이름", JOB "업무", HIREDATE "입사일" FROM EMP -- 단일행함수(4장 참조)
    WHERE HIREDATE > TO_DATE('81/01/31', 'RR-MM-DD');

-- ex. 연봉이 2400이상인 직원의 ENAME, SAL 연봉 출력(연봉 = SAL * 12)
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 >= 2400;
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 >= 2400; -- WHERE절에는 별칭을 쓸 수 없다
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 >= 2400 ORDER BY 연봉; -- ORDER BY절은 별칭 사용 가능

-- ex. 10번 부서(DEPTNO)이거나 직책(JOB)이 MANAGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';

-- ex. 부서번호가 10번이 아닌 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

-- 5. 산술표현식
-- 산술연산의 결과는 NULL을 포함하면 결과도 NULL
-- NVL(NULL일 수도 있는 필드명, 대체값) / 반드시 매개변수 둘은 타입이 같아야 함
SELECT ENAME, SAL "현재급여", SAL+100 "올릴급여" FROM EMP WHERE DEPTNO = 10;

-- ex. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12+COMM)
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;  -- 잘못된 표현식
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;

-- ex. 모든 사원의 사원명(ENAME), 상사의 사번(MGR)을 출력
SELECT EMPNO, ENAME, NVL(MGR, '없음') FROM EMP;  -- 매개변수 타입 불일치 에러
SELECT EMPNO, ENAME, NVL(MGR, 0) FROM EMP;

-- 6. 연결연산자(||) : 열이나 문자를 연결
SELECT ENAME || '은' || JOB "EMPLOYEES" FROM EMP;

-- ex. "SMITH : 연봉 = XXX"과 같이 모든 행 출력(연봉 = SAL*12+COMM)
SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

-- 7. 중복제거(DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- 8. SQL 연산자(BETWEEN, IN, LIKE, IS NULL)

-- (1) BETWEEN
-- 문법 : 데이터 BETWEEN A AND B (A <= B)
-- ex. SAL이 1500이상 3000이하인 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;

-- ex. 1500미만, 3000초과하는 모든 필드
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;

-- ex. 82년도에 입사한 지기원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

-- ex. 사원이름이 'A' 또는 'B'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME ^= 'C';

-- ex. 사원이름이 'B' 또는 'C'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D';

-- (2) IN
-- 문법 : 데이터 IN (A, B, C, ...)
-- ex. 부서번호가 10 또는 20 또는 40번인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20 OR DEPTNO = 40;
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);

-- ex. 부서번호가 10, 20, 40번을 제외한 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO NOT IN (10, 20, 40);

-- ex. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

-- (3) LIKE
-- 문법 : 데이터 LIKE 패턴(%:0글자이상, _:한글자)
-- ex. 이름이 M이 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%M%';

-- ex. 이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%';

-- ex. 이름이 S로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';

-- ex. SAL이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';

-- ex. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;

-- ex. 1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';

-- ex. 82년도가 아닌 년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';

-- ex. 이름에 %가 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
INSERT INTO EMP VALUES (9999, '홍%', NULL, NUll, NULL, 9000, 900, 40);
ROLLBACK; -- DML(추가, 삭제, 수정)로 수정된 데이터 원상복구

-- (4) IS NULL
-- ex. 상여금이 NULL인 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL;

-- ex. 상여금이 없는 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;

-- ex. 상여금이 있는 사원의 모든 필드
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM != 0;
SELECT * FROM EMP WHERE NOT (COMM IS NULL OR COMM = 0);

-- 9. 정렬(오름차순, 내림차순)
-- ORDER BY 데이터 (DEFAULT) : 오름차순 정렬
SELECT ENAME, SAL FROM EMP ORDER BY SAL;
SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- 이름 알파벳 순

-- ORDER BY 데이터 ASC : 오름차순
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- 월급 오름차순(LOW -> HIGH)
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- 날짜 빠른 순

-- ORDER BY 데이터 DESC : 내림차순
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;  -- 급여 내림차순 (HIGH -> LOW)
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- 이름 알파벳 역순
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- 날짜 최신순

-- ex. 이름, 연봉(SAL*12+COMM)을 출력 (연봉이 높은 순으로, 연봉이 같은 경우 이름순으로)
SELECT ENAME, SAL*12+NVL(COMM, 0) ANNUAL_SAL FROM EMP ORDER BY SAL*12+NVL(COMM, 0) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM, 0) ANNUAL_SAL FROM EMP ORDER BY ANNUAL_SAL DESC, ENAME;

-- ex. 사번, 이름, 입사일, 급여, 부서번호 (부서번호순, 부서가 같으면 입사일 오름차순)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;



