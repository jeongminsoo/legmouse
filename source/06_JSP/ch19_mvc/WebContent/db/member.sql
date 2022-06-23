DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL
);

INSERT INTO MEMBER (ID, PW, NAME, BIRTH) VALUES ('aaa', '111', '홍길동', NULL);
    
SELECT * FROM MEMBER;

COMMIT;