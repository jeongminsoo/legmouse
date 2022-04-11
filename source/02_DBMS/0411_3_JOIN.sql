-- [III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;

-- CROSS JOIN (FROM���� ���̺� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';

-- 1. EQUI JOIN (���� JOIN : ����� �÷��� ���� ������ �� ���� �������� JOIN(����)) 
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- ���̺��� ��Ī�� ������  ��Ī���θ� ���̺��� �������ؾ���
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

-- ex. �޿��� 2000�̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;

-- ex. LOC�� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ, �ٹ����� ���
SELECT ENAME, JOB, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

-- ex. �μ���ȣ�� 10 �Ǵ� 20�� ����� �̸�, ����, �ٹ���, �޿�(�޿��� ����)
SELECT ENAME, JOB, LOC, SAL 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10, 20) 
    ORDER BY SAL;

-- ex. JOB�� SALESMAN �̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM)*12), �μ���, �ٹ����� ���(������ ū������ ���)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0))*12, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND JOB IN ('SALESMAN', 'MANAGER') 
    ORDER BY (SAL+NVL(COMM, 0))*12 DESC;

-- ex. COMM�� NULL�̰� �޿��� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ���(�μ����, �޿�ū�� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200 
    ORDER BY DNAME, SAL DESC;

-- ex. 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

-- ex. 'ACCOUNTING' �μ� �Ҽ��� ����̸��� �Ի��� ���
SELECT ENAME, HIREDATE 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D. DEPTNO AND DNAME = 'ACCOUNTING';

-- ex. ����(JOB)�� MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';

-- ex. COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, SAL, E.DEPTNO, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;
    
-- �� 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT';  -- ��� ����
SELECT * FROM SALGRADE;  -- �޿� ��� ����
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN 
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL;

-- ex. ��� ����� ���, �̸�, ��å, �����, �޿�, �޿����(1���, 2���, ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;

-- �� 3. SELF JOIN
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

-- SMITH�� ��� ����
SELECT W.EMPNO, W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M
    WHERE W.ENAME = 'SMITH' AND W.MGR = M.EMPNO;

-- ex. ��� ����� ���, �̸�, �����, ����̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- ex. 'SMITH�� ���� FORD��' �������� ���  
SELECT W.ENAME || '�� ����' || M.ENAME || '��'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- �� 4. OUTER JOIN : JOIN �� ���ǿ� �������� ���� ����� ��Ÿ���� ��
-- ��簡 ���� ������� ���
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
 
-- ������ ���� �μ����� ���    
SELECT  ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO(+) = D.DEPTNO;

-- ���� ����� �̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;




