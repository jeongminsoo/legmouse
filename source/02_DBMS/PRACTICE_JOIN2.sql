-- �� <��������> PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME WORKER, W.SAL, W.JOB, M.ENAME MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME WORKER, W.SAL, W.JOB, NVL(M.ENAME, '����') MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME WORKER, W.SAL, DNAME, M.ENAME MANAGER FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME WORKER, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;

--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, M.ENAME
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL
    AND W.DEPTNO = D.DEPTNO AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, DNAME, (SAL+NVL(COMM, 0))*12 ANNALY_SAL, ENAME
    FROM EMP W, EMP M, SALGRADE, DEPT D
    

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
