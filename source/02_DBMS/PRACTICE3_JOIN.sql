-- ��������

--	1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL AND SAL BETWEEN LOSAL AND HISAL;

--	2. �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;

--	3. �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;

--	4. �̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, D.DEPTNO, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND NOT COMM IS NULL;

--	5. �̸�, �޿�, �޿����, ����, �μ���, (�μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0)
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12 ANNALY_SAL, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ANNALY_SAL; 

--	6. �̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL;

--	7. �̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND HIREDATE LIKE '81%' AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY GRADE;
    
-- 8. SCOTT�� ������ �μ���ȣ(20)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
-- 1�ܰ�
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME FROM EMP WHERE DEPTNO = 20 AND ENAME != 'SCOTT';

-- 2�ܰ�
SELECT E2.ENAME FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO AND E2.ENAME != 'SCOTT';


    
-- 9. SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');  -- ���������� DALLAS �ٹ��� �μ� �ϳ� �߰�
INSERT INTO EMP VALUES (9999, 'ȫ�浿', NULL, NULL, NULL, 9000, 900, 50);  -- ���������� 50�� �μ� ��� �߰�
SELECT * FROM EMP;

-- 1�ܰ�
SELECT ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO
    AND LOC = 'DALLAS' AND ENAME != 'SCOTT';
 
-- 2�ܰ�   
SELECT E2.ENAME FROM EMP E1, EMP E2, DEPT D1, DEPT D2
    WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = D1.DEPTNO AND E2.DEPTNO = D2.DEPTNO 
    AND D1.LOC = D2.LOC AND E2.ENAME != 'SCOTT';
    
-- 10. ����� �̸��� 'KING'�� ������� �̸��� ������ ���
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';
    