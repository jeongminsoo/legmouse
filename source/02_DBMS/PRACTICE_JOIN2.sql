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
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM, 0))*12 ANNALY_SAL, M.ENAME MANAGER
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.DEPTNO = D.DEPTNO;

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME WORKER, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM, 0))*12 ANNALY_SAL, M.ENAME MANAGER
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.DEPTNO = D.DEPTNO
    ORDER BY DNAME, W.SAL DESC;
    
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO ORDER BY ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000
    ORDER BY SAL DESC;

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER' AND SAL >= 2500
    ORDER BY EMPNO;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME WORKER, M.ENAME MANAGER, UM.ENAME UPPERMANAGER FROM EMP W, EMP M, EMP UM
    WHERE W.MGR = M.EMPNO AND M.MGR = UM.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME WORKER, M.ENAME MANAGER, UM.ENAME UPPERMANAGER FROM EMP W, EMP M, EMP UM
    WHERE W.MGR = M.EMPNO(+) AND M.MGR = UM.EMPNO(+);