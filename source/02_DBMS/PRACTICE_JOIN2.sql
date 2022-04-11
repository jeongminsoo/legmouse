-- ★ <연습문제> PART1
--1. 이름, 직속상사
SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--2. 이름, 급여, 업무, 직속상사
SELECT W.ENAME WORKER, W.SAL, W.JOB, M.ENAME MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT W.ENAME WORKER, W.SAL, W.JOB, NVL(M.ENAME, '없음') MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME WORKER, W.SAL, DNAME, M.ENAME MANAGER FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;

--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME WORKER, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;

--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, M.ENAME
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL
    AND W.DEPTNO = D.DEPTNO AND W.SAL >= 2000;

--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;

--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT ENAME, SAL, GRADE, DNAME, (SAL+NVL(COMM, 0))*12 ANNALY_SAL, ENAME
    FROM EMP W, EMP M, SALGRADE, DEPT D
    

--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
