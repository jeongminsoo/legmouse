-- [X] VIEW, INLINE VIEW, TOP-N ����
-- 1. VIEW : ������ ���̺�
-- (1) �ܼ��� : �ϳ��� ���̺��� ������ ��
SELECT * FROM USER_VIEWS;  -- ������ ��ųʸ� �� Ȯ��

-- SAL. COMM�� ������ �ٸ� �׸� ���̵��� VIEW����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ����

INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40); -- �信 INSERT �ϸ� EMP ���̺����� INSERT
UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO = 1111;  -- �� UPDATE �ϸ� EMP���̺��� UPDATE
DELETE FROM EMPv0 WHERE EMPNO = 1111;  -- �� DELETE �ϸ� EMP���̺��� DELETE

SELECT * FROM EMP;
SELECT * FROM EMPv0;  -- ������ ���̺�

-- 30�� �μ��� ���̵��� VIEW����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30;

DESC EMPv0;
SELECT * FROM EMPv0;
SELECT * FROM EMP;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30);

-- 20�� �μ� �Է��� ���������� ������ ���� / 30�� �μ��� ����
INSERT INTO EMPv0 VALUES (2222, '��', NULL, NULL, SYSDATE, 9000, 900, 20);
-- 20�� �μ��� ���� �ȵ� / 30�� �μ� �信���� 30�� �μ��� ���� ����
DELETE FROM EMPv0 WHERE EMPNO IN (1111, 2222);
DELETE FROM EMP WHERE EMPNO = 2222;

-- ENAME, JOB, HIREDATE ������ �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ', 'SALESMAN', SYSDATE);  -- INSERT �Ұ�
-- �� VIEW ������ NOT NULL �ʵ带 �� �����ؾ��� ��
COMMIT;

--  VIEW �� ���� ����
-- (1) ���� ����
-- (2) �б� ����
-- WITH CHECK OPTION�� ������ ��� ���� ���ǿ� �ش��ϴ� �����͸� ����, ����, ���� ����
-- WITH READ ONLY�� ������ ��� ���� ���� ��

-- 30�� �μ��� ���̴� VIEW ���� (WITH CHECK OPTION)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30);  -- 30�� �μ��� INSERT
INSERT INTO EMPv0 VALUES (1112, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 40);  -- WITH CHECK OPTION ����

SELECT * FROM EMP;
SELECT * FROM EMPv0;
DELETE FROM EMPv0 WHERE ENAME = 'SMITH'; -- WITH CHECK OPTION ����
DELETE FROM EMPv0 WHERE EMPNO = 1111;

-- �ϱ����� ��(WITH READ ONLY)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP
    WITH READ ONLY;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', 1234, 40); -- WITH READ ONLY ����

-- (2) ���պ� : 2�� �̻��� ���̺��� ������ ���̰ų� ������ �ʵ�� �並 ���� ���
--             DML���� ���������� ���
-- �� 2�� �̻��� ���̺�
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

SELECT * FROM EMPv0;

-- ���պ�� ���� �Ұ�(INSERT, DELETE, UPDATE)
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', 'RESEARCH', 'DALLAS');

-- �� ������ �ʵ�� �� : �÷��� ��Ī(������, ����, _)�� �̿��Ͽ� �� �����ؾ���
CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, ANNALY_SAL)  -- ��Ī�� ������ ����
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 10;
    
SELECT * FROM EMPv0;

-- ex. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ ��(DEPTv1) ����
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MIN_SAL, MAX_SAL, AVG_DSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), TRUNC(AVG(SAL)) FROM EMP
    GROUP BY DEPTNO;
    
SELECT * FROM DEPTv1;

-- ex. ��å, �μ��� ������ EMPv0 �並 ���� : DISTINCT�� ������ ��� �б� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO;
SELECT * FROM EMPv0;

-- 2. INLINE VIEW : FROM�� ���� ���������� INLINEVIEW�� �ϸ�, FROM���� ���� ���������� VIEWó�� �ۿ�
-- ex. �޿��� 2000���� ū ����� ��� �޿�
CREATE OR REPLACE VIEW EMPv0
    AS (SELECT AVG(SAL) FROM EMP WHERE SAL > 2000);

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL > 2000);

-- ex. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    
SELECT EMPNO, ENAME, SAL
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL > AVGSAL;

--  3. TOP-N ���� (TOP 1~10�� / TOP 11~20�� / TOP 6��~10��)
-- ROWNUM : FROM�� ���̺��κ��� ������ ����
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20;
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- ���, �̸�, SAL
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ���̺��� ���� ������ ����
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC);

-- �Լ��� �̿��� RANK ���
SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
    ENAME, SAL FROM EMP;

-- SAL ���� 1~5��
SELECT ROWNUM , ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5;
SELECT ROWNUM , ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10;

-- TOP-N ���� 1�ܰ�
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
-- TON-N ���� 2�ܰ�
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) 
    WHERE RN BETWEEN 6 AND 10;

-- �̸��� ���ĺ� ������� �����ؼ� 6~10��°���� ���
SELECT ROWNUM, RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;














