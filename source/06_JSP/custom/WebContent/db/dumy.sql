DROP TABLE MONEY;
DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE MONEY_SEQ;

CREATE TABLE MEMBER_LEVEL(
    GRADE CHAR(1) PRIMARY KEY,
    GNAME VARCHAR2(10)
);

INSERT INTO MEMBER_LEVEL VALUES ('A', 'VIP');
INSERT INTO MEMBER_LEVEL VALUES ('B', '일반');
INSERT INTO MEMBER_LEVEL VALUES ('C', '직원');

CREATE TABLE MEMBER(
    CUSTNO NUMBER(5) PRIMARY KEY,
    CUSTNAME VARCHAR2(20),
    PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(60),
    JOINDATE DATE DEFAULT SYSDATE,
    GRADE CHAR(1) REFERENCES MEMBER_LEVEL(GRADE),
    CITY CHAR(2)
);

CREATE SEQUENCE MEMBER_SEQ
    START WITH 10001
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;

INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '홍길동', '010-1111-2222', '서울 동대문구', '2022-07-02', 'A', '01');
INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '신길동', '010-1111-3333', '서울 강남구', '2022-06-01', 'B', '01');
INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '김길동', '010-1111-4444', '경기도 안양시', '2022-05-01', 'B', '30');
INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '유길동', '010-1111-5555', '경기도 의정부시', '2022-07-03', 'A', '30');
INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '정길동', '010-1111-6666', '서울 용산구', '2022-07-03', 'B', '60');

-- 회원등록
INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, GRADE,CITY)
    VALUES (MEMBER_SEQ.NEXTVAL, '최길동', '010-1111-7777', '서울 서초구', 'B', '60');
    
-- 회원목록
SELECT * FROM MEMBER;

--회원가져오기
SELECT * FROM MEMBER WHERE CUSTNO = 10001;

-- 최근 회원 번호
SELECT MAX(CUSTNO) MAX FROM MEMBER;

-- 정보 수정
UPDATE MEMBER SET CUSTNAME = '콩길동', PHONE = '010-2222-2222', ADDRESS = '서울시 중구', GRADE = 'A', CITY = '10'
    WHERE CUSTNO = '10005';
    
CREATE TABLE MONEY(
    SALENO NUMBER(6) PRIMARY KEY,
    CUSTNO NUMBER(5) REFERENCES MEMBER(CUSTNO),
    COST NUMBER(8),
    AMOUNT NUMBER(4),
    PRICE NUMBER(8),
    PCODE VARCHAR2(4),
    SDATE DATE DEFAULT SYSDATE
);

DELETE FROM MEMBER WHERE CUSTNO = 10007;
COMMIT;
 CREATE SEQUENCE MONEY_SEQ
    MAXVALUE 99
    NOCACHE
    NOCYCLE;
    
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10001', 100, 20, 2000, 'A01', '2022-07-01');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10001', 150, 20, 3000, 'A02', '2022-07-01');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10002', 200, 10, 2000, 'A03', '2022-07-01');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10003', 100, 5, 500, 'A01', '2022-07-01');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10004', 100, 9, 900, 'A01', '2022-07-02');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10003', 150, 6, 900, 'A02', '2022-07-03');
INSERT INTO MONEY VALUES (TRIM(TO_CHAR(SYSDATE, 'YYYY'))||TRIM(TO_CHAR(MONEY_SEQ.NEXTVAL, '00')), '10001', 200, 2, 400, 'A03', '2022-07-04');

SELECT * FROM MONEY;

-- 회원 매출 조회
SELECT A.*, CUSTNAME, GNAME 
    FROM (SELECT CUSTNO, SUM(PRICE) TOTAL FROM MONEY GROUP BY CUSTNO ORDER BY TOTAL DESC) A, MEMBER M, MEMBER_LEVEL ML
    WHERE A.CUSTNO = M.CUSTNO AND M.GRADE = ML.GRADE;
    
-- 제품 매출 조회
SELECT PCODE, SUM(PRICE) TOTAL FROM MONEY GROUP BY PCODE ORDER BY TOTAL DESC;
    
COMMIT;