-- Dept.xml 의 id=deptList
SELECT * FROM DEPT;
SELECT * FROM EMP;
-- Emp.xml의 id=empList
SELECT * FROM EMP WHERE 1 = 1
    AND ENAME LIKE '%'||'A'||'%'
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO = 20;