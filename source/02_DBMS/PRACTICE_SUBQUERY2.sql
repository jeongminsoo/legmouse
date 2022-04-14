-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND LOC = (SELECT LOC
                FROM DEPT
                WHERE LOC = 'DALLAS');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                    FROM EMP
                    WHERE ENAME = 'KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND DNAME = (SELECT DNAME
                    FROM DEPT
                    WHERE DNAME = 'SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                    FROM EMP
                    WHERE DEPTNO = 30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = 10
    AND JOB IN (SELECT JOB
                    FROM EMP
                    WHERE DEPTNO = 30);

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT * FROM EMP 
    WHERE (JOB, SAL) IN (SELECT JOB, SAL
                            FROM EMP
                            WHERE ENAME = 'FORD')
    AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'JONES')
    OR SAL >= (SELECT SAL
                FROM EMP
                WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL
                        FROM EMP
                        WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
    AND ENAME != 'SCOTT' AND ENAME != 'WARD';

-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND JOB IN (SELECT DISTINCT JOB 
                    FROM EMP E, DEPT D
                    WHERE E.DEPTNO = D.DEPTNO
                    AND LOC = 'CHICAGO')
    AND LOC != 'CHICAGO';

-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E1
    WHERE SAL > (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.DEPTNO = E2.DEPTNO);
                    
-- �μ���պ��� ���� ����� ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���(�Ҽ���2�ڸ�)
SELECT EMPNO, ENAME, SAL, DEPTNO, (SELECT ROUND(AVG(SAL), 2)
                                    FROM EMP E2
                                    WHERE E1.DEPTNO = E2.DEPTNO) "AVG"
    FROM EMP E1
    WHERE SAL > (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.DEPTNO = E2.DEPTNO);
    
    
-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, JOB
    FROM EMP E1
    WHERE SAL < (SELECT ROUND(AVG(SAL), 2)
                    FROM EMP E2
                    WHERE E1.JOB = E2.JOB);

-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP W
                    WHERE W.MGR = M.EMPNO)
    ORDER BY DEPTNO;


-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS (SELECT * FROM EMP W
                        WHERE M.EMPNO = W.MGR)
    ORDER BY DEPTNO;