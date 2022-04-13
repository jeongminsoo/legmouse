-- [��] ������ �Լ� : �����Լ�, SQL �ֿ��Լ�
-- �Լ� = ������ �Լ� + �׷��Լ�(�����Լ�)
-- ������ �Լ� (INPUT 1�� -> OUTPUT 1��)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') FROM EMP; -- ������ �Լ�
SELECT ENAME, INITCAP(ENAME) FROM EMP;

-- �׷� �Լ� (INPUT N�� -> OUTPUT 1��)
SELECT SUM(SAL) FROM EMP; -- ��ü SAL ��
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- �μ��� SAL ��

-- ������ �Լ� ���� : ���� ���� �Լ�, ���� ���� �Լ�, ��¥ ���� �Լ�(�����), ����ȯ �Լ�, NVL(), ETC ...
-- 1. ���� ���� �Լ�
-- DUAL ���̺� : ����Ŭ���� �����ϴ� 1�� 1��¥�� dummy table
DESC DUAL;
SELECT * FROM DUAL;
SELECT -9, ABS(-9) FROM DUAL; -- ���밪
SELECT FLOOR(34.5678) FROM DUAL;  -- �Ҽ������� ����
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� ����
SELECT TRUNC(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;  -- �Ҽ������� ����
SELECT TRUNC(34, -1) FROM DUAL;  -- ���� �ڸ����� ����

SELECT CEIL(34.5678) FROM DUAL;  -- �Ҽ������� �ø�
SELECT CEIL(34.5678*100)/100 FROM DUAL;  -- �Ҽ��� �ι�°�ڸ����� �ø�

SELECT ROUND(34.5678) FROM DUAL; -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL; -- ���� �ڸ����� �ݿø�

SELECT MOD(9, 2) FROM DUAL;  --������ ������ 9 % 2

-- ex. EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL, -2) FROM EMP;

-- ex. ����� Ȧ���� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(EMPNO, 2) != 0;

-- ex. Ȧ���޿� �Ի��� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) != 0;

-- 2. ���� ���� �Լ�
-- (1) ��ҹ��� ����
SELECT UPPER('abcABC') FROM DUAL;  -- �ҹ��� -> �빮��
SELECT LOWER('abcABC') FROM DUAL;  -- �빮�� -> �ҹ���
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL;  -- ù���ڸ� �빮��

-- ex. JOB�� 'manager'�� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';

-- (2) ���� ���� ( CONCAT, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT('AB', 'CD') FROM DUAL;  -- �Ű����� ���� 2�� ����
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT('EF', 'GH')) FROM DUAL;

-- ex. "�ƹ���(ENAME)�� XX(JOB)�̴�" �������� EMP ���̺� ���� ���
SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT(JOB, '�̴�')) FROM EMP;
SELECT ENAME||'�� '||JOB||'�̴�' FROM EMP;

-- (3) SUBSTR(STR, ������ġ,���ڰ���) ù��°��ġ : 1, ������ġ ���� ����
--     SUBSTRB(STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��)
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3��° ���ں��� 2���� ���� (AC)
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL; -- 3��° ����Ʈ���� 2����Ʈ ����(AC)
SELECT SUBSTR('�����ͺ��̽�', 4, 3) FROM DUAL; -- 4��° ���ں��� 3���� ����(���̽�)
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) FROM DUAL; -- 4��° ����Ʈ���� 3����Ʈ ����(��) �ѱ� 1���ڴ� 3BYTE
SELECT SUBSTR('ABCDXD', -1, 1) FROM DUAL;
SELECT SUBSTR(123, 2, 1) FROM DUAL;

-- ex. 9���� �Ի��� ����� ��� �ʵ�(��, data ��� format 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';

-- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ�(data ���� : 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';

-- (4) ���ڼ�(LENGTH) VS ����Ʈ��(LENGTHB)
SELECT LENGTH('ABC') FROM DUAL;   -- ���ڼ� : 3
SELECT LENGTHB('ABC') FROM DUAL;  -- ����Ʈ�� : 3
SELECT LENGTH('����Ŭ') FROM DUAL;  -- ���ڼ� : 3
SELECT LENGTHB('����Ŭ') FROM DUAL; -- ����Ʈ�� : 9

-- (5) INSTR(STR, ã�� ����) : STR���� ã�� ������ ��ġ ��ȯ / ���ڸ� ��ã���� 0 ��ȯ
--     INSTR(STR, ã�� ����, ������ġ) : STR���� ������ġ���� ã�Ƽ� ã�� ������ ��ġ ��ȯ
SELECT INSTR('ABCABC', 'B') FROM DUAL;
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL;
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL;

-- ex. 9���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE INSTR(HIREDATE, '/09/') = 3;
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 3) = 4;

-- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 6) = 7;

-- ex. 9���� �ƴ� �� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 6) = 0;
SELECT * FROM EMP WHERE NOT INSTR(HIREDATE, '09', 6) = 7;

-- (6) LPAD(STR, �ڸ���, ä�� ����) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���� ���
--     RPAD(STR, �ڸ���, ä�� ����) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�� ���� ���
SELECT LPAD('ABCABC', 10, '#') FROM DUAL;
SELECT RPAD('ABCABC', 10, '#') FROM DUAL;

-- ex. ���, �̸� (7788  S****)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') "NAME" FROM EMP;

-- ex. ���, �̸�, �Ի��� ( 7788, ____****H, 80/12/**)
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME", RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') "HIREDATE" FROM EMP;
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME", TO_CHAR(HIREDATE, 'RR/MM/')||'**' "HIREDATE" FROM EMP;

-- ex. �̸��� ����° �ڸ��� R�� ����� ��� �ʵ�(LIKE ���, INSTR ���, SUBSTR���)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 2) = 3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';

-- (7) ��������
--  TRIM(STR) : ���� ���� ����
--  RTRIM(STR) : ������ ���� ����
--  LTRIM(STR) : ���� ���� ����
SELECT TRIM('     ORACLE DB      ') FROM DUAL;
SELECT RTRIM('     ORACLE DB      ') "A" FROM DUAL;
SELECT LTRIM('     ORACLE DB      ') FROM DUAL;

-- (8) 
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', ' ') FROM EMP;

-- 3. ��¥ ���� �Լ� �� ����
-- (1) SYSDATE : ����
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL;
SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 FROM DUAL; -- ���� �� �ð�
SELECT SYSDATE+1 FROM DUAL; -- ���� �� �ð�

-- (2) ��¥��� : 14�� �� 
SELECT SYSDATE+14 "�ݳ�������" FROM DUAL;

-- ex. �̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "WORKINGDAY" FROM EMP;

-- ex. �̸�, �Ի���, �ٹ��ּ�, �ٹ����
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) "WORKINGWEEK", FLOOR((SYSDATE-HIREDATE)/365) "WORKINGYEAR" FROM EMP;

-- (3) MONTHS_BETWEEN(��¥, ��¥) : �� ��¥���� ���� ��
-- ex. �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "WORKINGDAY" FROM EMP;

-- ex. �̸�, �Ի��� ���� ���� �޿��� ��(�޿��� �Ŵ� sal�� �ް�, COMM�� 1�⿡ 2ȸ ����)
SELECT ENAME, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL) "TOTAL SAL", FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12)*2*NVL(COMM, 0) "TOTAL COMM" FROM EMP;

-- (4) ADD_MONTHS(��¥, ���� ��) : Ư���������� ���� �� ���� ��¥
-- ex. �̸�, �Ի���, ����������(�����Ⱓ�� �Ի��Ϸκ��� 6����)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "INTERN" FROM EMP;

-- 5) LAST_DAY(Ư����¥) : Ư����¥�� ���� ����
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- ex. �̸�, �Ի���, ù ����(���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "FIRST SAL" FROM EMP;

-- (6) ROUND(��¥, XX) : ��¥ �ݿø� / TRUNC(��¥, XX) : ��¥ ����
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- ��� : 1�� 1���� ����� �⵵�� ��ȯ
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;  -- ��� : 1���� ����� ���� ��ȯ
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;  -- ��� : �Ͽ����� ����� ��¥�� ��ȯ
SELECT ROUND(SYSDATE) FROM DUAL;  -- ��� : 0�ð� ����� 0�÷� ��ȯ

SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- ��� : ���� 1�� 1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;  -- ��� : �̹��� 1��
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;  -- ��� : ���� �Ͽ���
SELECT TRUNC(SYSDATE) FROM DUAL;  -- ��� : ���� 0��

-- ex. �̸�, �Ի���, �Ի��� ���� 5��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 FROM EMP;

-- ex. �̸�, �Ի���, ���޳�(���޳��� �Ŵ� 16��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 "SAL DAY" FROM EMP;

-- ex. �̸�, �Ի���, ���޳�(���޳��� �Ŵ� 15��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "SAL DAY" FROM EMP;

-- ex. �̸�, �Ի���, ���޳�(���޳��� �Ŵ� 5��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "SAL DAY" FROM EMP;

-- ex. �̸�, �Ի���, ���޳�(���޳��� �Ŵ� 20��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "SAL DAY" FROM EMP;

-- (7) NEXT_DAY(��¥, '��') : Ư����¥�κ��� ó�� �����ϴ� ������

-- 4. ����ȯ �Լ� (���� <->����, ���� <-> ��¥)

-- (1) TO_CHAR(��¥�� ������, '�������')
-- YYYY(�⵵ 4�ڸ�) YY / RR (�⵵ 2�ڸ�)  MM (��) DD(��)   DY / DAY(����)
-- AM / PM(����/���� ����)  HH12(12�ð�)   HH24(24�ð�)   MI(��)   SS(��)

SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY AM HH12:MI:SS') FROM DUAL;

-- (2) TO_CHAR(������ ������, '�������')
-- 0 : �ڸ���  (��� ������ �ڸ����� ������ 0���� ä��)
-- 9 : �ڸ���  (��� ������ �ڸ����� ���Ƶ� ���ڸ�ŭ ���)
-- , : ���ڸ����� , ����
-- . : �Ҽ���
-- $ : ��ȭ���� �޷�
-- L : ������ȭ����

SELECT TO_CHAR(123456, '9,999,999.99') FROM DUAL;
SELECT TO_CHAR(123456, '0,000,000.00') FROM DUAL;
SELECT TO_CHAR(10000, 'L999,999') FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,000') FROM EMP;

-- (3) TO_DATE(���ڵ�����, '����')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD') FROM DUAL;

-- ex. 81/5/1 ~ 83/5/1 ���̿� �Ի��� ������ ��� �ʵ�(TO_DATE)
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('810501', 'RRMMDD') AND TO_DATE('83/05/01', 'RR/MM/DD');

-- (4) TO_NUMBER(����, '����')
SELECT TO_NUMBER('3,456', '9,999') FROM DUAL;

-- 5. NVL(NULL�ϼ��� �ִ� ������, NULL�̸� ����� ��)  :  �Ű������� Ÿ���� ��ġ�ؾ� ��
-- ex. �̸�, ����� ���(MGR)�� ��� (����� ����� NULL�� ���, 'CEO'�� ��� ���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

-- 6. ETC
-- (1) EXTRACT : �⵵/��/�� �� ���ڷ� �����ϰ��� �Ҷ� ���
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM') FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;

-- ex. 2���� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '02';

-- ex. 81�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
SELECT * FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '81';

-- (2) ������ ���(������ ���) : LEVEL, START WITH ����, CONNECT BY PRIOR ����
SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME FROM EMP 
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO = MGR;



