-- TABLE 삭제 및 생성
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;
DROP TABLE ADMIN;
DROP SEQUENCE FILEBOARD_SEQ;

-- CUSTOMER TABLE
CREATE TABLE CUSTOMER (
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cEMAIL VARCHAR2(50),
    cFILENAME VARCHAR2(50),
    cBIRTH DATE NOT NULL,
    cADDRESS VARCHAR2(3000),
    cRDATE DATE DEFAULT SYSDATE NOT NULL
);

-- FILEBOARD TABLE
CREATE TABLE FILEBOARD(
    fNUM NUMBER(7) PRIMARY KEY,
    cID VARCHAR2(50) REFERENCES CUSTOMER (cID),
    aID VARCHAR2(50) REFERENCES ADMIN (aID),
    fTITLE VARCHAR2(250) NOT NULL,
    fCONTENT VARCHAR2(4000),
    fFILENAME VARCHAR2(50),
    fHIT NUMBER(7) DEFAULT 0 NOT NULL,
    fREF NUMBER(7) NOT NULL,
    fRE_STEP NUMBER(7) NOT NULL,
    fRE_LEVEL NUMBER(7) NOT NULL,
    fIP VARCHAR2(50) NOT NULL,
    fRDATE DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;

-- ADMIN TABLE
CREATE TABLE ADMIN(
    aID VARCHAR2(50) PRIMARY KEY,
    aPW VARCHAR2(50) NOT NULL,
    aNAME VARCHAR(50) NOT NULL
);
-- CUSTOMER DAO
-- 사용자 회원가입
INSERT INTO CUSTOMER (cID, cPW, cNAME, cEMAIL, cFILENAME, cBIRTH, cADDRESS)
    VALUES ('aaa', '111', '홍', 'hong@hong.com', 'hong.jpg', '1999-01-01', '서울');
    
-- 사용자 정보수정
UPDATE CUSTOMER SET cPW = '222', cNAME = '신', cEMAIL = 'sin@sin.com', cFILENAME = 'sin.jpg', cBIRTH = '1998-02-02', cADDRESS = '강남'
    WHERE cID = 'aaa';

-- 사용자 로그인
SELECT * FROM CUSTOMER WHERE cID = 'aaa' AND cPW = '222';


-- FILEBOARD DAO
-- 원글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fTITLE, fCONTENT, fFILENAME, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '제목', '본문', NULL, 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');

INSERT INTO FILEBOARD (fNUM, cID, fTITLE, fCONTENT, fFILENAME, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '제목2', '본문2', NULL, 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');

INSERT INTO FILEBOARD (fNUM, cID, fTITLE, fCONTENT, fFILENAME, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '제목3', '본문3', NULL, 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
    
INSERT INTO FILEBOARD (fNUM, cID, fTITLE, fCONTENT, fFILENAME, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '제목4', '본문4', NULL, 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
    
-- 글목록
SELECT fNUM, cID, aID, fTITLE, fHIT, fRDATE, fIP FROM FILEBOARD ORDER BY fREF DESC, fRE_STEP;

-- 글수
SELECT COUNT(*) FROM FILEBOARD;

-- 페이징
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT fNUM, cID, aID, fTITLE, fHIT, fRDATE, fIP FROM FILEBOARD ORDER BY fREF DESC, fRE_STEP) A)
    WHERE RN BETWEEN 1 AND 2;

-- 글보기
SELECT * FROM FILEBOARD WHERE fNUM = 1;

-- 글수정
UPDATE FILEBOARD SET fTITLE = '수정제목', fCONTENT = '수정본문', fFILENAME = 'java.txt', fIP = '190.168.10.168'
    WHERE fNUM = 1;
    
-- 조회수 증가
UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fNUM = 1;

-- 글삭제
DELETE FROM FILEBOARD WHERE fNUM = 2;

-- 답글쓰기
INSERT INTO FILEBOARD (fNUM, aID, fTITLE, fCONTENT, fFILENAME, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'hong', '답변에 답변', '답변에 답변 내용', NULL, 0, 3, 1, 1, '190.168.10.11');

-- 답글쓰기 전 STEP A
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fNUM = 6 AND fRE_STEP > 0;

-- 관리자 등록
INSERT INTO ADMIN VALUES ('hong', '123', '홍길동');

-- 관리자 로그인
SELECT * FROM ADMIN WHERE aID = 'hong' AND aPW = '123';