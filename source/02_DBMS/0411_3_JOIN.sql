-- [III] JOIN : 테이블 2개 이상을 연결하여 검색
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;

-- CROSS JOIN (FROM절에 테이블 2개 이상)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';

-- 1. EQUI JOIN (동등 JOIN : 공통된 컬럼의 값이 있을때 그 값을 기준으로 JOIN(연결)) 
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- 테이블의 별칭이 있으면  별칭으로만 테이블을 엑세스해야함
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

-- ex. 급여가 2000이상인 직원만 이름, 직책, 급여, 부서명, 근무지 출력
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;

-- ex. LOC이 'CHICAGO'인 사람의 이름, 업무, 급여, 부서번호, 근무지를 출력
SELECT ENAME, JOB, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

-- ex. 부서번호가 10 또는 20인 사원의 이름, 업무, 근무지, 급여(급여순 정렬)
SELECT ENAME, JOB, LOC, SAL 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10, 20) 
    ORDER BY SAL;

-- ex. JOB이 SALESMAN 이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉((SAL+COMM)*12), 부서명, 근무지를 출력(연봉이 큰순으로 출력)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0))*12, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND JOB IN ('SALESMAN', 'MANAGER') 
    ORDER BY (SAL+NVL(COMM, 0))*12 DESC;

-- ex. COMM이 NULL이고 급여가 1200이상인 사람의 이름, 급여, 입사일, 부서번호, 부서명 출력(부서명순, 급여큰순 정렬)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200 
    ORDER BY DNAME, SAL DESC;

-- ex. 'NEW YORK'에서 근무하는 사원의 이름과 급여 출력
SELECT ENAME, SAL 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

-- ex. 'ACCOUNTING' 부서 소속의 사원이름과 입사일 출력
SELECT ENAME, HIREDATE 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D. DEPTNO AND DNAME = 'ACCOUNTING';

-- ex. 직급(JOB)이 MANAGER인 사원의 이름, 부서명 출력
SELECT ENAME, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';

-- ex. COMM이 NULL이 아닌 사원의 이름, 급여, 부서번호, 근무지 출력
SELECT ENAME, SAL, E.DEPTNO, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;
    
-- ★ 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT';  -- 사원 정보
SELECT * FROM SALGRADE;  -- 급여 등급 정보
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN 
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL;

-- ex. 모든 사원의 사번, 이름, 직책, 상사사번, 급여, 급여등급(1등급, 2등급, ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'등급' GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;

-- ★ 3. SELF JOIN
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

-- SMITH의 상사 정보
SELECT W.EMPNO, W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M
    WHERE W.ENAME = 'SMITH' AND W.MGR = M.EMPNO;

-- ex. 모든 사원의 사번, 이름, 상사사번, 상사이름
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- ex. 'SMITH의 상사는 FORD다' 포멧으로 출력  
SELECT W.ENAME || '의 상사는' || M.ENAME || '다'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- ★ 4. OUTER JOIN : JOIN 시 조건에 만족하지 않은 행까지 나타나게 함
-- 상사가 없는 사람까지 출력
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
 
-- 나오지 않은 부서까지 출력    
SELECT  ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO(+) = D.DEPTNO;

-- 말단 사원의 이름
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;




