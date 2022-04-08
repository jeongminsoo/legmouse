-- [��] SELECT �� - ���� ���� ���̴� DML(Data Manipulation Language) : �˻� ���
-- 1. SELECT���� �ۼ���

-- ���� ���� (���� : ctrl + Enter)
SHOW USER;
SELECT * FROM TAB;  -- �� ����(scott)�� ���̺� Ȯ��
SELECT * FROM EMP;  -- EMP ���̺��� ��� ��(�ʵ�), ����� Ȯ��
SELECT * FROM DEPT; -- DEPT ���̺��� ��� ��, ��� ��

-- EMP ���̺��� ����
DESC EMP;
DESC DEPT;

-- 2. SQL�� ���� (Ư�� ���� ���)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB FROM EMP; -- ��Ī
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�, JOB FROM EMP;
SELECT EMPNO  ���, ENAME  �̸�, SAL  �޿�, JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP;  -- TITLE : NO, NAME, SALARY

-- 3. Ư�� �ุ ��� : WHERE ��(����) / �񱳿����� - ����(=), �ٸ���(!= / ^= / <>)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000;  -- ����
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL != 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL ^= 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL <> 3000; -- �ٸ���

-- �񱳿����ڴ� ����, ����, ��¥�� ��� ����
-- ex. ����̸�(ENAME)�� 'A', 'B', 'C',�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME < 'D';

-- ex. 81�⵵ ������ �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';

-- ex. 10�� �μ���ȣ(deptno)�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10;

-- ex. �̸�(ENAME)�� FORD�� ������ ���(EMPNO), ENAME, MGR
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
select empno, ename, mgr from emp where ename = 'FORD';  -- �����ʹ� ��ҹ��� ����

-- 4. �������� : AND, OR, NOT
-- ex. �޿�(SAL)�� 2000�̻� 3000������ ������ ��� �ʵ�
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <= 3000;

-- ex. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

-- ex. ��¥ ǥ��� ���� (���� : YY/MM/DD = RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- �ѱ� Windows ���� ��¥ ����
SELECT ENAME, HIREDATE FROM EMP;

-- ex. ������ 2400�̻��� ������ ENAME, SAL ���� ���(���� = SAL * 12)
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 >= 2400;
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 >= 2400; -- WHERE������ ��Ī�� �� �� ����
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 >= 2400 ORDER BY ����; -- ORDER BY���� ��Ī ��� ����

-- ex. 10�� �μ�(DEPTNO)�̰ų� ��å(JOB)�� MANAGER�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';

-- ex. �μ���ȣ�� 10���� �ƴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

-- 5. ���ǥ����
-- ��������� ����� NULL�� �����ϸ� ����� NULL
-- NVL(NULL�� ���� �ִ� �ʵ��, ��ü��) / �ݵ�� �Ű����� ���� Ÿ���� ���ƾ� ��
SELECT ENAME, SAL "����޿�", SAL+100 "�ø��޿�" FROM EMP WHERE DEPTNO = 10;

-- ex. ��� ����� �̸�(ENAME), ����(SAL), ��(COMM), ����(SAL*12+COMM)
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;  -- �߸��� ǥ����
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;

-- ex. ��� ����� �����(ENAME), ����� ���(MGR)�� ���
SELECT EMPNO, ENAME, NVL(MGR, '����') FROM EMP;  -- �Ű����� Ÿ�� ����ġ ����
SELECT EMPNO, ENAME, NVL(MGR, 0) FROM EMP;

-- 6. ���Ῥ����(||) : ���̳� ���ڸ� ����
SELECT ENAME || '��' || JOB "EMPLOYEES" FROM EMP;

-- ex. "SMITH : ���� = XXX"�� ���� ��� �� ���(���� = SAL*12+COMM)
SELECT ENAME || ' : ���� = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

-- 7. �ߺ�����(DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- �� �������� �� Ǯ��

--1. emp ���̺��� ���� ���
DESC EMP;

--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;

--3. �� scott �������� ��밡���� ���̺� ���
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