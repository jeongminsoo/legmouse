-- DELETE
SELECT * FROM DEPT;
DELETE FROM DEPT WHERE DEPTNO = 40;
ROLLBACK;
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
COMMIT;

SELECT EMPNO, ENAME, JOB, SAL FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('SALES');

SELECT * FROM DEPT WHERE DNAME = 'OPERATIONS';

    