-- 조건 2
DROP TABLE CUS_LEVEL;
DROP TABLE CUSTOMER;

-- 조건3 테이블 생성    
CREATE TABLE CUSTOMER (
    CNO NUMBER(1),
    CNAME VARCHAR2(15) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE,
    PHONE VARCHAR2(13),
    POINT NUMBER(7),
    LEVELNO NUMBER(1),
    PRIMARY KEY (CNO),
    UNIQUE (PHONE),
    CHECK (POINT >= 0),
    FOREIGN KEY (LEVELNO) REFERENCES CUS_LEVEL (LEVELNO) );

-- 조건4 테이블 생성
CREATE TABLE CUS_LEVEL (
    LEVELNO NUMBER(1),
    LEVELNAME VARCHAR2(6) NOT NULL,
    PRIMARY KEY (LEVELNO) );

-- 조건5 시퀀스 생성
CREATE SEQUENCE CUS_SQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

-- CUS_LEVEL DUMMY 데이터 삽입
 INSERT INTO CUS_LEVEL VALUES (1, 'VVIP');
 INSERT INTO CUS_LEVEL VALUES (2, 'VIP');   
 INSERT INTO CUS_LEVEL VALUES (3, 'NORMAL');   
 INSERT INTO CUS_LEVEL VALUES (4, 'BLACK');   
 
-- CUSTOMER DUMMY 데이터 삽입
INSERT INTO CUSTOMER VALUES (CUS_SQ.NEXTVAL, '홍길동', '22/03/10', '010-9999-9999', 0, 1);
INSERT INTO CUSTOMER (CNO, CNAME, JOINDATE, PHONE, LEVELNO) 
    VALUES (CUS_SQ.NEXTVAL, '이철수', '22/04/19', '010-8888-8888', 2);

-- 조건6 실행
SELECT CNO, CNAME, TO_CHAR(JOINDATE, 'YYYY-MM-DD') "JOINDATE", PHONE, POINT, LEVELNAME
    FROM CUSTOMER C, CUS_LEVEL CL
    WHERE C.LEVELNO = CL.LEVELNO;









