-- <�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
    
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME "WORKER", M.ENAME "MANAGER" FROM EMP W, EMP M WHERE W.MGR = M.EMPNO(+);
    
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���).
SELECT DEPTNO, SUMSAL, ROWNUM
    FROM (SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL));

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT RN, DEPTNO, SUMSAL
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL)) A)
    WHERE RN > 1;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT *
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM <= 5;
    
SELECT EMPNO, ENAME, HIREDATE 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 1 AND 5;


-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;
