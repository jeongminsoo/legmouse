-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) 
    FROM EMP;

-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(JOB) 
    FROM EMP
    GROUP BY JOB;

--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL) 
    FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL), 2), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO 
    ORDER BY SUM(SAL) DESC;

-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;

-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;

--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 5;

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >= 5;

--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >= 3000;

--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) > 5000
    ORDER BY SUM(SAL) DESC;

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, ROUND(AVG(SAL), 2), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(ROUND(AVG(SAL), 2)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;

--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') "H_YEAR", COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL), 1) "AVG(SAL)", SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY H_YEAR;


-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total') "H_YEAR", COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'));

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL), 2)
    FROM EMP;

--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 6;

--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME, COUNT(E2.ENAME)+1 "RANK"
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK;

-- RANK() OVER(ORDER BY SAL DESC)
-- DENSE_RANK() OVER(ORDER BY SAL DESC)
-- ROW_NUMBER() OVER(ORDER BY SAL DESC)