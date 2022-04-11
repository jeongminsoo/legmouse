-- �� �������� �� Ǯ��

--1. emp ���̺��� ���� ���(����Ŭ������ ����)
DESC EMP;

--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;

--3. �� scott �������� ��밡���� ���̺� ���
SHOW USER; -- �� ���� ���� Ȯ�� 
SELECT * FROM TAB; 

--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�", JOB "����", HIREDATE "�Ի���" FROM EMP;

--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL < 2000;

--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP WHERE HIREDATE > '81/01/31';

--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';

--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;

--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", SAL "�޿�" FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';

--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME ||'�� '||JOB||' �����̰� ������ '||(SAL*12+NVL(COMM, 0))||'��' FROM EMP;