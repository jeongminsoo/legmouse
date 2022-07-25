DROP TABLE BOOK CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;

DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE BOOK_SEQ;

CREATE TABLE BOOK(
    BNO NUMBER(8) PRIMARY KEY,
    BTITLE VARCHAR2(100) NOT NULL,
    BWRITER VARCHAR2(100) NOT NULL,
    BRDATE DATE DEFAULT SYSDATE NOT NULL,
    BIMG1 VARCHAR2(100) DEFAULT 'noImg.png' NOT NULL,
    BIMG2 VARCHAR2(100) DEFAULT 'noImg.png' NOT NULL,
    BINFO VARCHAR2(1000)
);

CREATE TABLE MEMBER(
    MID VARCHAR2(100) PRIMARY KEY,
    MPW VARCHAR2(100) NOT NULL,
    MNAME VARCHAR2(100) NOT NULL,
    MEMAIL VARCHAR2(100) NOT NULL,
    MPOST VARCHAR2(100),
    MADDRESS VARCHAR2(100)
);

CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 99999999
    NOCACHE
    NOCYCLE;

INSERT INTO MEMBER VALUES ('aaa', '123', '홍길동', 'hong@naver.com', '12345', '서울특별시');

SELECT * FROM MEMBER WHERE MID = 'aaa';

SELECT * FROM MEMBER WHERE MID = 'aaa' AND MPW = '123';

UPDATE MEMBER SET MPW = '111', MNAME = '홍홍홍', MEMAIL = 'leekr44@naver.com', MPOST = '1231', MADDRESS = '경기도' WHERE MID = 'aaa';

INSERT INTO BOOK (BNO, BTITLE, BWRITER, BRDATE, BIMG1, BIMG2, BINFO) VALUES (BOOK_SEQ.NEXTVAL, '책책책', '저자', '2022-06-01', 'noImg.png', 'noImg.png', '내용');
INSERT INTO BOOK (BNO, BTITLE, BWRITER, BRDATE, BIMG1, BIMG2, BINFO) VALUES (BOOK_SEQ.NEXTVAL, 'SPRING', '스프링', '2022-05-01', NULL, 'noImg.png', '스프링개념서');
INSERT INTO BOOK (BNO, BTITLE, BWRITER, BRDATE, BIMG1, BIMG2, BINFO) VALUES (BOOK_SEQ.NEXTVAL, 'ORACLE', '오라클', '2022-07-25','noImg.png', NULL, '오라클개념서');

SELECT * FROM BOOK WHERE BNO = 1;

UPDATE BOOK SET BTITLE = '수정책', BWRITER = '수정저자', BIMG1 = 'noImg.png', BIMG2 = 'noImg.png', BINFO = '수정 내용' WHERE BNO = 1;

SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;

SELECT * FROM BOOK ORDER BY BRDATE DESC;

