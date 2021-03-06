-- [Ⅴ] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)

SELECT ENAME, ROUND(SAL, -3) FROM EMP;  -- 단일행 함수(4장)
SELECT MAX(SAL) FROM EMP;  -- 그룹 함수 (5장)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT ENAME, MAX(SAL) FROM EMP;  -- 에러 (단일행함수와 그룹함수(다중행) 같이 사용) 최대 급여를 받는 사람의 이름(6장)

-- 1. 그룹함수 실습
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT COUNT(*) FROM EMP;  -- 테이블의 행(ROW) 수
SELECT ROUND(AVG(SAL), 2), ROUND(SUM(SAL)/COUNT(SAL), 2) FROM EMP;
SELECT COMM FROM EMP;
SELECT SUM(COMM) FROM EMP;
SELECT AVG(COMM) FROM EMP;
SELECT COUNT(COMM) FROM EMP;
SELECT MIN(COMM) FROM EMP;
SELECT MAX(COMM) FROM EMP;   

-- 모든 그룹함수는 NULL값을 제외(예외 : COUNT(*)) 

-- SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 갯수
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
SELECT SQRT(VARIANCE(SAL)) FROM EMP;  -- SQRT(값) : 값에 루트 처리

-- MIN, MAX, COUNT 는 숫자형, 문자형, 날짜형 모두 사용 가능
SELECT MIN(HIREDATE), MAX(HIREDATE), COUNT(HIREDATE) FROM EMP;
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) FROM EMP;

-- ex1. 가장 최근에 입사한 사원의 입사일과 가장최초입사한 사원의 입사일
SELECT MAX(HIREDATE) "최근입사일", MIN(HIREDATE) "최초입사일" FROM EMP;

-- ex2. 83/01/12 최근입사일 : XX,XXX일 근무, 80/12/17 최초입사일 : XX,XXX일 근무
SELECT MAX(HIREDATE)||' 최근입사일 : '||TO_CHAR(SYSDATE-MAX(HIREDATE), '99,999')||
    '일 근무, '||MIN(HIREDATE)||' 최초입사일 : '||TO_CHAR(SYSDATE-MIN(HIREDATE), '99,999')||'일 근무' FROM EMP;
SELECT MAX(HIREDATE)||' 최근입사일 : '||TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999')||'일 근무, '||
    MIN(HIREDATE) || ' 최초입사일 : '||TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999')||'일 근무' FROM EMP;
    
-- 부서번호 10의 급여평균
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10;

-- 2. GROUP BY
-- 컬럼의 별칭 사용 불가 / ORDER BY 는 사용 가능
-- ex. 부서번호, 최대급여, 최소급여, 급여평균, 급여합, 부서원 수
SELECT DEPTNO 부서, MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)), SUM(SAL), COUNT(DEPTNO) FROM EMP GROUP BY DEPTNO;

-- ex. SAL이 5000미만인 사원에 대해서 부서별 부서번호, 사원수, 최대급여, 최소급여, 평균급여 (부서번호 오름차순 정렬)
SELECT DEPTNO 부서, COUNT(DEPTNO), MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) FROM EMP WHERE SAL < 5000 GROUP BY DEPTNO ORDER BY 부서;

-- ex. 부서명, 사원수, 최대급여, 최소급여, 평균급여 (사원 수 내림차순 정렬)
SELECT DNAME, COUNT(*) 사원수, MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME ORDER BY 사원수 DESC;

-- 3. HAVING
-- 별칭 사용 불가
-- 부서번호, 평균급여 (평균급여가 2000이상)
SELECT DEPTNO, TRUNC(AVG(SAL)) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;

-- ex. 급여가 5000이상인 사원에 대해 부서명, 최소급여, 최대급여, 평균급여 출력(평균급여 1800 이상)
SELECT DNAME 부서, MIN(SAL) 최소급여, MAX(SAL) 최대급여, AVG(SAL) 평균급여
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND SAL < 5000
    GROUP BY DNAME
    HAVING AVG(SAL) >= 1800
    ORDER BY 평균급여;

-- 4. 결과 집계합 내 집계값 생성
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

-- ex. 부서번호, JOB, 급여합
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;

-- ex. 부서번호, JOB, 급여합(소계, 전체합 포함)
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);




