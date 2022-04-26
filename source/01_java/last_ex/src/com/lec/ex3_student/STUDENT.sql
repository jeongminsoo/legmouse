-- 테이블 생성
DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SQ;

CREATE TABLE MAJOR (
    MNO NUMBER(1),
    MNAME VARCHAR2(30) NOT NULL,
    PRIMARY KEY (MNO) );
    
CREATE TABLE STUDENT (
    SNO NUMBER(7),
    SNAME VARCHAR2(15) NOT NULL,
    MNO NUMBER(1),
    SCORE NUMBER(3) DEFAULT 0,
    EXPEL NUMBER(1) DEFAULT 0,
    PRIMARY KEY (SNO),
    FOREIGN KEY (MNO) REFERENCES MAJOR (MNO),
    CHECK (SCORE BETWEEN 0 AND 100) );
     
CREATE SEQUENCE STUDENT_SQ
    START WITH 001
    MAXVALUE 999
    NOCACHE
    NOCYCLE;
    
INSERT INTO MAJOR VALUES (1, '빅데이터학');
INSERT INTO MAJOR VALUES (2, '경영정보학');
INSERT INTO MAJOR VALUES (3, '컴퓨터공학');
INSERT INTO MAJOR VALUES (4, '응용물리학');
INSERT INTO MAJOR VALUES (5, '인공지능학');

INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '홍길동', (SELECT MNO FROM MAJOR WHERE MNAME = '인공지능학'), 99, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '정우성', (SELECT MNO FROM MAJOR WHERE MNAME = '빅데이터학'), 90, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '박세영', (SELECT MNO FROM MAJOR WHERE MNAME = '인공지능학'), 80, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '배수지', (SELECT MNO FROM MAJOR WHERE MNAME = '컴퓨터공학'), 20, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '조세호', (SELECT MNO FROM MAJOR WHERE MNAME = '경영정보학'), 70, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '유재석', (SELECT MNO FROM MAJOR WHERE MNAME = '응용물리학'), 85, 0);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '신정환', (SELECT MNO FROM MAJOR WHERE MNAME = '응용물리학'), 10, 1);
INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '홍길동', (SELECT MNO FROM MAJOR WHERE MNAME = '빅데이터학'), 90, 0);


SELECT * FROM STUDENT;

SELECT * FROM MAJOR;

-- 학번검색
SELECT SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND SNO = 2022001;

-- 이름 검색
SELECT SNO, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND SNAME = '홍석천';

-- 전공검색
SELECT ROWNUM||'등' "RANK", NAME, SMNAME, SCORE
    FROM (SELECT SNAME||'('||S.SNO||')' "NAME", MNAME||'('||S.MNO||')' "SMNAME", SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND MNAME = '응용물리학' ORDER BY SCORE DESC);


-- 학생수정
UPDATE STUDENT SET SCORE = 100, SNAME = '홍경민', MNO = (SELECT MNO FROM MAJOR WHERE MNAME = '경영정보학') WHERE SNO = 2022001;

-- 학생출력
SELECT ROWNUM||'등' "RANK", NAME, SMNAME, SCORE
    FROM (SELECT SNAME||'('||S.SNO||')' "NAME", MNAME||'('||S.MNO||')' "SMNAME", SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL != 1 ORDER BY SCORE DESC);
    
-- 제적처리
UPDATE STUDENT SET EXPEL = 1 WHERE SNO = 2022001;

-- 제적자 출력
SELECT ROWNUM||'등' "RANK", NAME, SMNAME, SCORE
    FROM (SELECT SNAME||'('||S.SNO||')' "NAME", MNAME||'('||S.MNO||')' "SMNAME", SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL = 1 ORDER BY SCORE DESC);
    
-- 전공 리스트
SELECT MNAME FROM MAJOR;
    
COMMIT;

UPDATE STUDENT SET EXPEL = 0 WHERE SNAME = '홍경민';