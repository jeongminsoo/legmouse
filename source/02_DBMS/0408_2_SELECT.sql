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

-- ��¥�� -> ���������� ��ȯ�ϴ� �Լ� : TO_CHAR(��¥��, ����)
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP -- �������Լ�(4�� ����)
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/01/31';
    
-- ������ -> ��¥������ ��ȯ�ϴ� �Լ� : TO_DATE(������, ����)
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP -- �������Լ�(4�� ����)
    WHERE HIREDATE > TO_DATE('81/01/31', 'RR-MM-DD');

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

-- 8. SQL ������(BETWEEN, IN, LIKE, IS NULL)

-- (1) BETWEEN
-- ���� : ������ BETWEEN A AND B (A <= B)
-- ex. SAL�� 1500�̻� 3000������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;

-- ex. 1500�̸�, 3000�ʰ��ϴ� ��� �ʵ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;

-- ex. 82�⵵�� �Ի��� ������� ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

-- ex. ����̸��� 'A' �Ǵ� 'B'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME ^= 'C';

-- ex. ����̸��� 'B' �Ǵ� 'C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D';

-- (2) IN
-- ���� : ������ IN (A, B, C, ...)
-- ex. �μ���ȣ�� 10 �Ǵ� 20 �Ǵ� 40���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20 OR DEPTNO = 40;
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);

-- ex. �μ���ȣ�� 10, 20, 40���� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO NOT IN (10, 20, 40);

-- ex. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

-- (3) LIKE
-- ���� : ������ LIKE ����(%:0�����̻�, _:�ѱ���)
-- ex. �̸��� M�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%';

-- ex. �̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';

-- ex. �̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';

-- ex. SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';

-- ex. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;

-- ex. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';

-- ex. 82�⵵�� �ƴ� �⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';

-- ex. �̸��� %�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
INSERT INTO EMP VALUES (9999, 'ȫ%', NULL, NUll, NULL, 9000, 900, 40);
ROLLBACK; -- DML(�߰�, ����, ����)�� ������ ������ ���󺹱�

-- (4) IS NULL
-- ex. �󿩱��� NULL�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL;

-- ex. �󿩱��� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;

-- ex. �󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM != 0;
SELECT * FROM EMP WHERE NOT (COMM IS NULL OR COMM = 0);

-- 9. ����(��������, ��������)
-- ORDER BY ������ (DEFAULT) : �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL;
SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- �̸� ���ĺ� ��

-- ORDER BY ������ ASC : ��������
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- ���� ��������(LOW -> HIGH)
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- ��¥ ���� ��

-- ORDER BY ������ DESC : ��������
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;  -- �޿� �������� (HIGH -> LOW)
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- �̸� ���ĺ� ����
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- ��¥ �ֽż�

-- ex. �̸�, ����(SAL*12+COMM)�� ��� (������ ���� ������, ������ ���� ��� �̸�������)
SELECT ENAME, SAL*12+NVL(COMM, 0) ANNUAL_SAL FROM EMP ORDER BY SAL*12+NVL(COMM, 0) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM, 0) ANNUAL_SAL FROM EMP ORDER BY ANNUAL_SAL DESC, ENAME;

-- ex. ���, �̸�, �Ի���, �޿�, �μ���ȣ (�μ���ȣ��, �μ��� ������ �Ի��� ��������)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;



