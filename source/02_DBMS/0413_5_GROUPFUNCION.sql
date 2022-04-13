-- [��] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)

SELECT ENAME, ROUND(SAL, -3) FROM EMP;  -- ������ �Լ�(4��)
SELECT MAX(SAL) FROM EMP;  -- �׷� �Լ� (5��)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT ENAME, MAX(SAL) FROM EMP;  -- ���� (�������Լ��� �׷��Լ�(������) ���� ���) �ִ� �޿��� �޴� ����� �̸�(6��)

-- 1. �׷��Լ� �ǽ�
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT COUNT(*) FROM EMP;  -- ���̺��� ��(ROW) ��
SELECT ROUND(AVG(SAL), 2), ROUND(SUM(SAL)/COUNT(SAL), 2) FROM EMP;
SELECT COMM FROM EMP;
SELECT SUM(COMM) FROM EMP;
SELECT AVG(COMM) FROM EMP;
SELECT COUNT(COMM) FROM EMP;
SELECT MIN(COMM) FROM EMP;
SELECT MAX(COMM) FROM EMP;   

-- ��� �׷��Լ��� NULL���� ����(���� : COUNT(*)) 

-- SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, ����
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
SELECT SQRT(VARIANCE(SAL)) FROM EMP;  -- SQRT(��) : ���� ��Ʈ ó��

-- MIN, MAX, COUNT �� ������, ������, ��¥�� ��� ��� ����
SELECT MIN(HIREDATE), MAX(HIREDATE), COUNT(HIREDATE) FROM EMP;
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) FROM EMP;

-- ex1. ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� ���������Ի��� ����� �Ի���
SELECT MAX(HIREDATE) "�ֱ��Ի���", MIN(HIREDATE) "�����Ի���" FROM EMP;

-- ex2. 83/01/12 �ֱ��Ի��� : XX,XXX�� �ٹ�, 80/12/17 �����Ի��� : XX,XXX�� �ٹ�
SELECT MAX(HIREDATE)||' �ֱ��Ի��� : '||TO_CHAR(SYSDATE-MAX(HIREDATE), '99,999')||
    '�� �ٹ�, '||MIN(HIREDATE)||' �����Ի��� : '||TO_CHAR(SYSDATE-MIN(HIREDATE), '99,999')||'�� �ٹ�' FROM EMP;
SELECT MAX(HIREDATE)||' �ֱ��Ի��� : '||TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999')||'�� �ٹ�, '||
    MIN(HIREDATE) || ' �����Ի��� : '||TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999')||'�� �ٹ�' FROM EMP;
    
-- �μ���ȣ 10�� �޿����
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10;

-- 2. GROUP BY
-- �÷��� ��Ī ��� �Ұ� / ORDER BY �� ��� ����
-- ex. �μ���ȣ, �ִ�޿�, �ּұ޿�, �޿����, �޿���, �μ��� ��
SELECT DEPTNO �μ�, MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)), SUM(SAL), COUNT(DEPTNO) FROM EMP GROUP BY DEPTNO;

-- ex. SAL�� 5000�̸��� ����� ���ؼ� �μ��� �μ���ȣ, �����, �ִ�޿�, �ּұ޿�, ��ձ޿� (�μ���ȣ �������� ����)
SELECT DEPTNO �μ�, COUNT(DEPTNO), MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) FROM EMP WHERE SAL < 5000 GROUP BY DEPTNO ORDER BY �μ�;

-- ex. �μ���, �����, �ִ�޿�, �ּұ޿�, ��ձ޿� (��� �� �������� ����)
SELECT DNAME, COUNT(*) �����, MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME ORDER BY ����� DESC;

-- 3. HAVING
-- ��Ī ��� �Ұ�
-- �μ���ȣ, ��ձ޿� (��ձ޿��� 2000�̻�)
SELECT DEPTNO, TRUNC(AVG(SAL)) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;

-- ex. �޿��� 5000�̻��� ����� ���� �μ���, �ּұ޿�, �ִ�޿�, ��ձ޿� ���(��ձ޿� 1800 �̻�)
SELECT DNAME �μ�, MIN(SAL) �ּұ޿�, MAX(SAL) �ִ�޿�, AVG(SAL) ��ձ޿�
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND SAL < 5000
    GROUP BY DNAME
    HAVING AVG(SAL) >= 1800
    ORDER BY ��ձ޿�;

-- 4. ��� ������ �� ���谪 ����
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

-- ex. �μ���ȣ, JOB, �޿���
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;

-- ex. �μ���ȣ, JOB, �޿���(�Ұ�, ��ü�� ����)
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);




