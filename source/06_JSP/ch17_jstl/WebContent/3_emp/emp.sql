-- Dao query

-- 전체 list
SELECT * FROM EMP;

-- 검색
SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER('')||'%' AND JOB LIKE '%'||UPPER('')||'%';