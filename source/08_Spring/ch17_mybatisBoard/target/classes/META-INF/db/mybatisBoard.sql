DROP TABLE BOARD;
DROP SEQUENCE BOARD_SEQ;
CREATE TABLE BOARD(
    BNO NUMBER(6) PRIMARY KEY,
    BNAME VARCHAR2(10) NOT NULL,
    BTITLE VARCHAR2(100) NOT NULL,
    BCONTENT VARCHAR2(4000),
    BRDATE DATE DEFAULT SYSDATE,
    BHIT NUMBER(6) DEFAULT 0,
    BGROUP NUMBER(6) NOT NULL,
    BSTEP NUMBER(6),
    BINDENT NUMBER(6),
    BIP VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE BOARD_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

-- boardWrite
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목', '내용', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목1', '내용1', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목2', '내용2', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목3', '내용3', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목4', '내용4', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목5', '내용5', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목6', '내용6', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목7', '내용7', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목8', '내용8', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목9', '내용9', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목10', '내용10', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍길동', '제목11', '내용11', BOARD_SEQ.CURRVAL, 0, 0, '127.0.0.1');



-- boardList
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A)
    WHERE RN BETWEEN 1 AND 10;
    
-- hitup
UPDATE BOARD SET BHIT = BHIT + 1 WHERE BNO = 1;

-- beforstepA
UPDATE BOARD SET BSTEP = BSTEP + 1 WHERE BGROUP = 1 AND BSTEP > 0;

-- boardReply
INSERT INTO BOARD (BNO, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '답글', '답글제목', '답변내용', 3, 0+1, 0+1, '127.0.0.1');

-- count
SELECT COUNT(*) FROM BOARD;

-- update
UPDATE BOARD SET BNAME = '홍홍홍', BTITLE = '수정제목', BCONTENT = '수정내용', BIP = '127.0.0.2'
    WHERE BNO = 3;
    
-- delete
DELETE FROM BOARD WHERE BNO = 1;

-- boardDetail
SELECT * FROM BOARD WHERE BNO = 2;

COMMIT;