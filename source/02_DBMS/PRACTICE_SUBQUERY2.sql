-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT EMPNO, ENAME, SAL
    FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND LOC = (SELECT LOC
                FROM DEPT
                WHERE LOC = 'DALLAS');

-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                    FROM EMP
                    WHERE ENAME = 'KING');

-- 17. SALES부서 사원의 이름, 업무
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND DNAME = (SELECT DNAME
                    FROM DEPT
                    WHERE DNAME = 'SALES');

-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                    FROM EMP
                    WHERE DEPTNO = 30);

-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = 10
    AND JOB IN (SELECT JOB
                    FROM EMP
                    WHERE DEPTNO = 30);

-- 20.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT * FROM EMP 
    WHERE (JOB, SAL) IN (SELECT JOB, SAL
                            FROM EMP
                            WHERE ENAME = 'FORD')
    AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'JONES')
    OR SAL >= (SELECT SAL
                FROM EMP
                WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;

-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL
                        FROM EMP
                        WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
    AND ENAME != 'SCOTT' AND ENAME != 'WARD';

-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND JOB IN (SELECT DISTINCT JOB 
                    FROM EMP E, DEPT D
                    WHERE E.DEPTNO = D.DEPTNO
                    AND LOC = 'CHICAGO')
    AND LOC != 'CHICAGO';

-- 24. 부서별로 월급이 평균 월급보다 높은 사원을 사번, 이름, 급여, 부서번호
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E1
    WHERE SAL > (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.DEPTNO = E2.DEPTNO);
                    
-- 부서평균보다 높은 사원의 사번, 이름, 급여, 부서번호, 해당부서의 평균(소수점2자리)
SELECT EMPNO, ENAME, SAL, DEPTNO, (SELECT ROUND(AVG(SAL), 2)
                                    FROM EMP E2
                                    WHERE E1.DEPTNO = E2.DEPTNO) "AVG"
    FROM EMP E1
    WHERE SAL > (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.DEPTNO = E2.DEPTNO);
    
    
-- 25. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT EMPNO, ENAME, SAL, JOB
    FROM EMP E1
    WHERE SAL < (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.JOB = E2.JOB);

-- 26. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP W
                    WHERE W.MGR = M.EMPNO)
    ORDER BY DEPTNO;


-- 27.  말단 사원의 사번, 이름, 업무, 부서번호
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS (SELECT * FROM EMP W
                        WHERE M.EMPNO = W.MGR)
    ORDER BY DEPTNO;